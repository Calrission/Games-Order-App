package com.example.orderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

lateinit var onChangeTotalSum: OnChangeTotalSum
val list: MutableList<Game> = arrayListOf()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onChangeTotalSum = object: OnChangeTotalSum{
            override fun onChange(new_sum: Int, count: Int) {
                subtotal_price.text = "$" + new_sum.toString()
                total_price.text = "$" + new_sum.toString()
                total_count.text = "Total ${count} item's"

                empty.visibility = if (count == 0) View.VISIBLE else View.INVISIBLE
            }
        }

        empty.visibility = View.VISIBLE

        rec_order.apply{
            adapter = AdapterRecOrder(list)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        complete_order.setOnClickListener {
            list.clear()
            rec_order.adapter!!.notifyDataSetChanged()
            empty.visibility = if (list.size == 0) View.VISIBLE else View.INVISIBLE
            subtotal_price.text = "$0"
            total_price.text = "$0"
            total_count.text = "Total 0 item's"
            showDialogAlert(this, "Заказ отправлен", "Спасибо за заказ !")
        }

        add_game.setOnClickListener {
            addGame(Random.nextInt(1000, 10000).toString())
        }
    }

    private fun addGame(id: String){
        initRetrofit().game(id).enqueue(object: Callback<Game>{
            override fun onResponse(call: Call<Game>, response: Response<Game>) {
                if (response.body() != null) {
                    list.add(response.body()!!)
                    rec_order.adapter!!.notifyItemInserted(list.size - 1)
                    rec_order.layoutManager!!.scrollToPosition(list.size - 1)
                }else{
                    Toast.makeText(this@MainActivity, "Ошибка получения ${id}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Game>, t: Throwable) {
                showDialogAlert(this@MainActivity, "Ошибка получения игры", t)
            }

        })
    }
}