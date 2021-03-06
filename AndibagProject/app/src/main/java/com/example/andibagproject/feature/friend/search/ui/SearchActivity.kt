package com.example.andibagproject.feature.friend.search.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivitySearchBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.friend.add.ui.AddFriendActivity
import com.example.andibagproject.feature.friend.search.adapter.RecyclerViewEmptySupport
import com.example.andibagproject.feature.friend.search.adapter.SearchFriendAdapter
import com.example.andibagproject.feature.friend.search.model.SearchFriendRequest
import com.example.andibagproject.feature.friend.search.model.SearchFriendResponse
import com.example.andibagproject.feature.friend.search.viewmodel.SearchFriendViewModel
import com.example.andibagproject.feature.settingDialogDelete
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {

    private val vm: SearchFriendViewModel by viewModel()

    private val searchFriendAdapter : SearchFriendAdapter by lazy {
        SearchFriendAdapter(binding.rv,this,vm)
    }

    private var searchFriendList = arrayListOf<SearchFriendResponse>()/*.apply {
        add(SearchFriendResponse(0,"user1","01012345678"))
        add(SearchFriendResponse(0,"user1","01012345678"))
        add(SearchFriendResponse(0,"user1","01012345678"))
        add(SearchFriendResponse(0,"user1","01012345678"))
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.loadSearchFriendList()

        binding.run {

            imageBack.setOnClickListener {
                finish()
            }

            btnAddFriendPage.setOnClickListener {
                startActivity(Intent(applicationContext,AddFriendActivity::class.java))
                finish()
            }

            btnDelete.setOnClickListener {
                settingDialogDelete(this@SearchActivity, "?????? ????????? ?????? ?????????????????????????") { helpDialog() }
            }

            imageSearch.setOnClickListener {
                vm.searchFriend(SearchFriendRequest( editText.text.toString()))
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

    private fun helpDialog(){
        searchFriendAdapter.removeAll()
        checkRecyclerViewAdapterEmpty()
    }

    fun checkRecyclerViewAdapterEmpty(){
        Handler().postDelayed({
            val emptyObserver = RecyclerViewEmptySupport(binding.rv, binding.layoutFindFriend, binding.btnDelete)
            searchFriendAdapter.registerAdapterDataObserver(emptyObserver) },200)
    }

    override fun observeEvent() {
        vm.run {
            searchFail.observe(this@SearchActivity) {
                when(it){
                    403 -> showToastShort("?????? ????????? ????????????")
                    401 -> showToastShort("?????? ???????????? ?????????????????? ???????????? ????????????")
                    404 -> showToastShort("???????????? ?????? ???????????????")
                    500 -> showToastShort("????????? ??????????????????")
                }
            }

            searchSuccess.observe(this@SearchActivity) {

                var id : Long = -1
                searchId.observe(this@SearchActivity){
                    id = it
                }

                var name = ""
                searchNickname.observe(this@SearchActivity) {
                    name  = it
                }

                var phoneNumber = ""
                searchPhoneNumber.observe(this@SearchActivity) {
                    phoneNumber = it
                }

                searchFriendAdapter.addItem(id,name,phoneNumber)
                checkRecyclerViewAdapterEmpty()

            }

            loadFail.observe(this@SearchActivity) {
                when(it){
                    403,401 -> showToastShort("?????? ????????? ????????????")
                    500 -> showToastShort("????????? ??????????????????")
                }
            }

            loadList.observe(this@SearchActivity) {
                searchFriendList = it.saveList
            }

            deleteAllSuccess.observe(this@SearchActivity) {
                when(it){
                    204 -> showToastShort("?????? ?????? ????????? ??????????????????")
                    else -> {
                        searchFriendAdapter.removeAll()
                        checkRecyclerViewAdapterEmpty()
                    }
                }
            }

            deleteAllFail.observe(this@SearchActivity) {
                when(it){
                    403, 401 -> showToastShort("?????? ????????? ????????????")
                    404 -> showToastShort("??????????????? ?????? ??? ????????????")
                    500 -> showToastShort("????????? ??????????????????")
                }
            }
        }
    }
    fun itemObserveEvent(recyclerView: RecyclerView, layoutPosition: Int){
        vm.run {
            deleteSuccess.observe(this@SearchActivity) {
                when(it){
                    204 -> showToastShort("?????? ?????? ????????? ??????????????????")
                    else -> (recyclerView.adapter as SearchFriendAdapter).removeItem(layoutPosition)
                }
            }

            deleteFail.observe(this@SearchActivity) {
                when(it){
                    401,403 -> showToastShort("?????? ????????? ????????????")
                    404 -> showToastShort("??????????????? ?????? ??? ????????????")
                    500 -> showToastShort("????????? ??????????????????")
                }
            }
        }
    }
}