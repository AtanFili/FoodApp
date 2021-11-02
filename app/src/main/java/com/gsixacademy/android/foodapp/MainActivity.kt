package com.gsixacademy.android.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mylayout.view.*
import android.view.ViewGroup as ViewGroup1

class MainActivity : AppCompatActivity() {

    var adapter:FoodAdapter?= null
    var foodlist=ArrayList<Food>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodlist.add(Food(name = "Coffee",des = "Coffee preparation is the proces of turning the coffee beans into beverrage",image = R.drawable.coffee_pot))
        foodlist.add(Food(name = "Esspresso",des = "Esspresso.....Not Ekspreso",image = R.drawable.coffee))
        foodlist.add(Food(name = "French Fries",des = "Pomfrit...ednostavno e",image = R.drawable.french_fries))
        foodlist.add(Food(name = "Honey",des = "Doagja od Boc Boc zivotni",R.drawable.honey))
        foodlist.add(Food(name = "Strawberry",des = "NOM NOM NOM",R.drawable.strawberry_ice_cream))
        foodlist.add(Food(name = "Sugar cubes",des = "Seker ama vo kocka",R.drawable.sugar_cubes))


        adapter= FoodAdapter(this,foodlist)
        gridview.adapter=adapter

    }
    class FoodAdapter: BaseAdapter {
        var foodlist = ArrayList<Food>()
        var context:Context?=null

        constructor(context: Context?,foodlist: ArrayList<Food>, ) : super() {
            this.foodlist = foodlist
            this.context = context
        }

        override fun getView(index: Int, p1: View?, p2: ViewGroup1?): View {
           var food:Food=this.foodlist[index]
            var inflater=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview=inflater.inflate(R.layout.mylayout,null)
            foodview.imageView.setImageResource(food.image!!)
            foodview.textView.text=food.name!!
            foodview.imageView.setOnClickListener{
                var intent= Intent(context,FoodDetailsActivity::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)

                context!!.startActivity(intent)

            }
            return foodview

        }

        override fun getItem(p0: Int): Any {
            return p0
        }
        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return  foodlist.size
        }






    }
}