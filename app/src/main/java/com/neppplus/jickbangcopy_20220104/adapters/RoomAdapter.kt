package com.neppplus.jickbangcopy_20220104.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.neppplus.jickbangcopy_20220104.R
import com.neppplus.jickbangcopy_20220104.ViewRoomDetailActivity
import com.neppplus.jickbangcopy_20220104.models.RoomData

class RoomAdapter(
    val mContext : Context,
    val mList : List<RoomData>
    ) : RecyclerView.Adapter<RoomAdapter.MyViewHolder>() {

    inner class MyViewHolder(val row : View) : RecyclerView.ViewHolder(row) {

        val txtPrice = row.findViewById<TextView>(R.id.txtPrice)
        val txtAddressAndFloor = row.findViewById<TextView>(R.id.txtAddressAndFloor)
        val txtDescription = row.findViewById<TextView>(R.id.txtDescription)

        fun bind(data: RoomData) {

            txtDescription.text = data.description

//            가격이나 층수는 추가 가공이 필요함
            txtAddressAndFloor.text = "${data.address}, ${data.getFormattedFloor()}"

            txtPrice.text = data.getFormattedPrice()


//            전체 한 줄을 표현하는 row 변수에게 클릭 이벤트 처리
            row.setOnClickListener {

//                임시 : 토스트 출력
//                Toast.makeText(mContext, "${data.description}", Toast.LENGTH_SHORT).show()

//                실제 : 상세보기 화면으로 이동(Intent)

                val myIntent = Intent(mContext, ViewRoomDetailActivity::class.java)


//                어떤 방인지 데이터를 들고, 화면을 이동하자(putExtra)
                myIntent.putExtra("room", data)

//                화면의 도움을 받아 -> 다른 화면으로 이동하는 startActivity
                mContext.startActivity(myIntent)

            }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val row = LayoutInflater.from(mContext).inflate(R.layout.room_list_item, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(mList[position])

    }

    override fun getItemCount(): Int {
        return mList.size
    }
}