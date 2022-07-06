package com.example.andibagproject.feature.friend.search.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivitySearchBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.friend.add.ui.AddFriendActivity
import com.example.andibagproject.feature.friend.search.adapter.RecyclerViewEmptySupport
import com.example.andibagproject.feature.friend.search.adapter.SearchFriendAdapter
import com.example.andibagproject.feature.friend.search.model.SearchFriendResponse
import com.example.andibagproject.feature.friend.search.viewmodel.SearchFriendViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.FieldPosition

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
                settingDialog()
            }

            imageSearch.setOnClickListener {
                vm.searchFriend(editText.text.toString())
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

            //vm.deleteAllFriendList()
        }
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
                    403 -> showToastShort("다시 로그인 해주세요")
                    401 -> showToastShort("다른 계정으로 로그인하거나 재로그인 해주세요")
                    404 -> showToastShort("존재하지 않는 번호입니다")
                    500 -> showToastShort("서버가 닫혀있습니다")
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
                    403,401 -> showToastShort("다시 로그인 해주세요")
                    500 -> showToastShort("서버가 닫혀있습니다")
                }
            }

            loadList.observe(this@SearchActivity) {
                searchFriendList = it.saveList
            }

            deleteAllSuccess.observe(this@SearchActivity) {
                when(it){
                    204 -> showToastShort("검색 기록 삭제에 실패했습니다")
                    else -> {
                        searchFriendAdapter.removeAll()
                        checkRecyclerViewAdapterEmpty()
                    }
                }
            }

            deleteAllFail.observe(this@SearchActivity) {
                when(it){
                    403, 401 -> showToastShort("다시 로그인 해주세요")
                    404 -> showToastShort("검색기록을 찾을 수 없습니다")
                    500 -> showToastShort("서버가 닫혀있습니다")
                }
            }
        }
    }
    fun itemObserveEvent(recyclerView: RecyclerView, layoutPosition: Int){
        vm.run {
            deleteSuccess.observe(this@SearchActivity) {
                when(it){
                    204 -> showToastShort("검색 기록 삭제에 실패했습니다")
                    else -> (recyclerView.adapter as SearchFriendAdapter).removeItem(layoutPosition)
                }
            }

            deleteFail.observe(this@SearchActivity) {
                when(it){
                    401,403 -> showToastShort("다시 로그인 해주세요")
                    404 -> showToastShort("검색기록을 찾을 수 없습니다")
                    500 -> showToastShort("서버가 닫혀있습니다")
                }
            }
        }
    }
}