package com.example.andibagproject.feature.friend.search.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.core.view.size
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivitySearchBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.friend.add.ui.AddFriendActivity
import com.example.andibagproject.feature.friend.search.adapter.RecyclerViewEmptySupport
import com.example.andibagproject.feature.friend.search.adapter.SearchFriendAdapter
import com.example.andibagproject.feature.friend.search.model.SearchFriendResponse
import kotlinx.coroutines.delay
import java.text.FieldPosition

class SearchActivity : BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {

    private val searchFriendAdapter : SearchFriendAdapter by lazy {
        SearchFriendAdapter(binding.rv,this)
    }

    private val searchFriendList = arrayListOf<SearchFriendResponse>().apply {
        add(SearchFriendResponse("user1"))
        add(SearchFriendResponse("user2"))
        add(SearchFriendResponse("user3"))
        add(SearchFriendResponse("user4"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            imageBack.setOnClickListener {
                finish()
            }

            btnAddFriendPage.setOnClickListener {
                startActivity(Intent(applicationContext,AddFriendActivity::class.java))
                finish()
            }

            btnDelete.setOnClickListener {
                settingDialog()
            }

            imageSearch.setOnClickListener {
                searchFriendAdapter.addItem(editText.text.toString())
                checkRecyclerViewAdapterEmpty()
            }

            rv.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
                adapter = searchFriendAdapter

            }
            searchFriendAdapter.submitList(searchFriendList)
            checkRecyclerViewAdapterEmpty()
        }
    }

    private fun settingDialog(){
        val dialog = Dialog(this@SearchActivity)
        dialog.setContentView(R.layout.dialog_search_friend_all_delete)
        dialog.setCancelable(false)
        dialog.show()

        val dialogBtnCancel : Button = dialog.findViewById(R.id.dialog_btn_cacel)
        val dialogBtnCheck : Button = dialog.findViewById(R.id.dialog_btn_check)

        dialogBtnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialogBtnCheck.setOnClickListener {
            dialog.dismiss()
            searchFriendAdapter.removeAll()

            checkRecyclerViewAdapterEmpty()
        }
    }

    fun checkRecyclerViewAdapterEmpty(){
        Handler().postDelayed({
            val emptyObserver = RecyclerViewEmptySupport(binding.rv, binding.layoutFindFriend, binding.btnDelete)
            searchFriendAdapter.registerAdapterDataObserver(emptyObserver) },200)
    }

    override fun observeEvent() {}
}