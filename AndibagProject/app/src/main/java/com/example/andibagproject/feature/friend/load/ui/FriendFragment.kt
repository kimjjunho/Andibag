package com.example.andibagproject.feature.friend.load.ui
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andibagproject.feature.main.MainActivity
import com.example.andibagproject.R
import com.example.andibagproject.databinding.FragmentFriendBinding
import com.example.andibagproject.feature.base.BaseFragment
import com.example.andibagproject.feature.friend.search.ui.SearchActivity
import com.example.andibagproject.feature.friend.add.ui.AddFriendActivity
import com.example.andibagproject.feature.friend.load.adapter.LoadFriendAdapter
import com.example.andibagproject.feature.friend.load.adapter.LoadFriendSwipeHelper
import com.example.andibagproject.feature.friend.load.model.LoadFriendResponse
import com.example.andibagproject.feature.friend.load.viewmodel.FriendViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FriendFragment : BaseFragment<FragmentFriendBinding>(R.layout.fragment_friend) {
    val vm : FriendViewModel by viewModel()

    private val loadFriendAdapter : LoadFriendAdapter by lazy {
        LoadFriendAdapter(binding.rv)
    }

    private val loadFriendList = arrayListOf<LoadFriendResponse>().apply {
        add(LoadFriendResponse(1,"친구1","01012345678"))
        add(LoadFriendResponse(1,"친구2","01012345678"))
        add(LoadFriendResponse(1,"친구3","01012345678"))
        add(LoadFriendResponse(1,"친구4","01012345678"))
        add(LoadFriendResponse(1,"친구5","01012345678"))
        add(LoadFriendResponse(1,"친구6","01012345678"))
    }


    override fun initView() {
        val context = activity as MainActivity
        //vm.loadFriend()
        binding.run {

            imageSearch.setOnClickListener {
                startActivity(Intent(context, SearchActivity()::class.java))
            }
            imageAdd.setOnClickListener {
                startActivity(Intent(context, AddFriendActivity()::class.java))
            }

            rv.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
                adapter = loadFriendAdapter
            }
            loadFriendAdapter.submitList(loadFriendList)
            val swipeHelper = LoadFriendSwipeHelper(loadFriendAdapter).apply {
                setClamp(resources.displayMetrics.widthPixels.toFloat() / 5)
            }
            ItemTouchHelper(swipeHelper).attachToRecyclerView(binding.rv)
        }
    }

    override fun observeEvent() {
        vm.run {
            success.observe(this@FriendFragment){
                it.run {
                    Log.d(TAG, "observeEvent: $it")
                }
            }
            fail.observe(this@FriendFragment){
                it.run {
                    when(it){
                        401,403 -> showToast("다시 로그인 해주세요")
                    }
                }
            }
        }
    }
}