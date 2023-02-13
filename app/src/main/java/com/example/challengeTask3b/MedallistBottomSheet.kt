package com.example.challengeTask3b

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MedallistBottomSheet : BottomSheetDialogFragment() {
    private lateinit var medallist: Medallist

    companion object {
        fun newInstance(medallist: Medallist): MedallistBottomSheet {
            val args = Bundle().apply {
                putParcelable("medallist", medallist)
            }
            return MedallistBottomSheet().apply { arguments = args }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        medallist = requireArguments().getParcelable("medallist")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_medallist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bind the Medallist data to the views
        view.findViewById<TextView>(R.id.country_text_view_bottom_sheet).text = medallist.country
        view.findViewById<TextView>(R.id.ioc_text_view_bottom_sheet).text = medallist.ioc
        view.findViewById<TextView>(R.id.competed_text_view_bottom_sheet).text = medallist.competed.toString()
        view.findViewById<TextView>(R.id.gold_text_view_bottom_sheet).text = medallist.gold.toString()
        view.findViewById<TextView>(R.id.silver_text_view_bottom_sheet).text = medallist.silver.toString()
        view.findViewById<TextView>(R.id.bronze_text_view_bottom_sheet).text = medallist.bronze.toString()
    }
}