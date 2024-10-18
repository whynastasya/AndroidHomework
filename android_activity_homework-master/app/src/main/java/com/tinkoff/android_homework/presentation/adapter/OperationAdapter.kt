package com.tinkoff.android_homework.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tinkoff.android_homework.R
import com.tinkoff.android_homework.presentation.model.operations.OperationItem
import com.tinkoff.android_homework.presentation.model.operations.OperationType

/**
 * @author d.a.korotkov
 */
class OperationAdapter : RecyclerView.Adapter<OperationAdapter.OperationViewHolder>() {

    var data: List<OperationItem> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.operation_recycler_item, parent, false)
        return OperationViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: OperationViewHolder, position: Int) {
        data[position].let { operationItem ->
            val operationIcon = when (operationItem.operationType) {
                OperationType.OUTCOME -> R.drawable.spending_icon
                OperationType.INCOME -> R.drawable.income_icon
            }
            holder.operationIcon.setImageResource(operationIcon)

            holder.operationTitle.text = operationItem.operationTitle
            holder.operationSum.text = operationItem.operationSum.toString()
        }
    }

    class OperationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val operationIcon: ImageView = itemView.findViewById(R.id.operation_icon)
        val operationTitle: TextView = itemView.findViewById(R.id.operation_title)
        val operationSum: TextView = itemView.findViewById(R.id.operation_sum)
    }
}
