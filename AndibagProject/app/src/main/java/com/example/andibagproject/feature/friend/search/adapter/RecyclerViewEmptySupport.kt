package com.example.andibagproject.feature.friend.search.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewEmptySupport(rv: RecyclerView?,cl: ConstraintLayout?, btn: Button):RecyclerView.AdapterDataObserver(){

    private var emptyView: ConstraintLayout? = null
    private var recyclerView: RecyclerView? = null
    private var button: Button? = null

    init {
        recyclerView = rv
        emptyView = cl
        button = btn
        checkIfEmpty()
    }

    private fun checkIfEmpty(){
        if(emptyView != null && recyclerView!!.adapter != null){
            val emptyViewVisible = recyclerView!!.adapter!!.itemCount == 0
            Log.d(TAG, "checkIfEmpty: "+recyclerView!!.adapter!!.itemCount)

            recyclerView!!.visibility = if(emptyViewVisible)
                View.INVISIBLE else View.VISIBLE
            button!!.visibility = if(emptyViewVisible)
                View.INVISIBLE else View.VISIBLE
        }
    }

    override fun onChanged() {
        super.onChanged()
        checkIfEmpty()
    }
}