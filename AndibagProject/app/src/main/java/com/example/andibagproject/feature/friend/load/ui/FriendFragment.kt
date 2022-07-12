package com.example.andibagproject.feature.friend.load.ui
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andibagproject.ACCESS_TOKEN
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
import com.example.andibagproject.util.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class FriendFragment : BaseFragment<FragmentFriendBinding>(R.layout.fragment_friend) {
    private val vm : FriendViewModel by viewModel()

    private val loadFriendAdapter : LoadFriendAdapter by lazy {
        val context = activity as MainActivity

        LoadFriendAdapter(binding.rv,context)
    }

  //  private val loadFriendList = arrayListOf<LoadFriendResponse>()

    private var loadFriendList = listOf<LoadFriendResponse>(
        LoadFriendResponse(1,"d",null,"df")
    )

    override fun initView() {

        vm.loadMyProfile()
        //vm.loadFriend()

        loadFriendAdapter.submitList(loadFriendList)

        binding.run {

            imageSearch.setOnClickListener {
                startActivity(Intent(requireContext(), SearchActivity()::class.java))
            }
            imageAdd.setOnClickListener {
                startActivity(Intent(requireContext(), AddFriendActivity()::class.java))
            }

            binding.rv.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
                adapter = loadFriendAdapter
            }

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

                }
            }
            fail.observe(this@FriendFragment){
                it.run {
                    when(it){
                        401,403 -> showToast("다시 로그인 해주세요")
                        else -> Log.d(TAG, "observeEvent: $it")
                    }
                }
            }
            friendList.observe(this@FriendFragment) {
                loadFriendList = it.friendList
                loadFriendAdapter.submitList(loadFriendList)

            }

            myPhoneNumber.observe(this@FriendFragment){
                binding.tvName.text = it
            }
            myImageUrl.observe(this@FriendFragment){
                loadImage(binding.myImageview,it)
            }
            myPhoneNumber.observe(this@FriendFragment){
                binding.tvPhoneNumber.text = it
            }
            myProfileFail.observe(this@FriendFragment){
                when(it){
                    403, 401 -> showToast("다시 로그인 해주세요")
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        observeEvent()
    }
}