package com.neppplus.jickbangcopy_20220104

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.neppplus.jickbangcopy_20220104.adapters.RoomAdapter
import com.neppplus.jickbangcopy_20220104.models.RoomData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mRoomList = ArrayList<RoomData>()    // 변수명의 m : 멤버변수라는 표식

    lateinit var mRoomAdapter : RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mRoomList.add(RoomData(8000, "서울지 동대문구", 5, "1번째 방입니다."))
        mRoomList.add(RoomData(4520,"서울시 남대문구", 0, "2번째 방입니다."))
        mRoomList.add(RoomData(100000, "서울지 동대문구", 3, "3번째 방입니다."))
        mRoomList.add(RoomData(7500, "서울지 동작구", -1, "4번째 방입니다."))
        mRoomList.add(RoomData(4200, "서울지 광진구", 0, "5번째 방입니다."))
        mRoomList.add(RoomData(62100, "서울지 동대문구", -4, "6번째 방입니다."))
        mRoomList.add(RoomData(18000, "서울지 동대문구", 7, "7번째 방입니다."))
        mRoomList.add(RoomData(1200, "서울지 광진구", 20, "8번째 방입니다."))
        mRoomList.add(RoomData(8800, "서울지 동대문구", 2, "9번째 방입니다."))

        mRoomAdapter = RoomAdapter(this, mRoomList)
        roomRecyclerView.adapter = mRoomAdapter

        roomRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}