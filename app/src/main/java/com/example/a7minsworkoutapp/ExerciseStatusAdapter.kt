package com.example.a7minsworkoutapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minsworkoutapp.databinding.ItemExerciseStatusBinding

class ExerciseStatusAdapter(val items: ArrayList<ExerciseModel>):
    RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {

        class ViewHolder(binding: ItemExerciseStatusBinding):
            RecyclerView.ViewHolder(binding.root){
                val tvItem = binding?.tvItem
            }


    //this is where we return our viewholder that we just created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemExerciseStatusBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }


    //what should happen for every single item when the view is bound
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ExerciseModel = items[position]

        holder.tvItem.text = model.getId().toString()

        when{
            model.getIsSelected() -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context,
                    R.drawable.item_circular_thin_color_border)

                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }

            model.getIsCompleted()->{
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context,
                        R.drawable.item_circular_color_accent_background)

                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }

            else -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context,
                        R.drawable.item_circular_color_gray_background)

                //holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
        }
    }


    //return the size of the arraylist that is given to the adapter
    override fun getItemCount(): Int {
        return items.size
    }

}