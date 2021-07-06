package pt.svcdev.endlesslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import pt.svcdev.endlesslist.model.Child

class MainListAdapter : PagingDataAdapter<Child, MainListAdapter.ViewHolder>(DataDifferentiator) {
    override fun onBindViewHolder(holder: MainListAdapter.ViewHolder, position: Int) {
        holder.itemView.title.text = getItem(position)?.data?.title
        holder.itemView.selftext.text = getItem(position)?.data?.sefltext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    object DataDifferentiator : DiffUtil.ItemCallback<Child>() {
        override fun areItemsTheSame(oldItem: Child, newItem: Child): Boolean {
            return oldItem.data.title == newItem.data.title
        }

        override fun areContentsTheSame(oldItem: Child, newItem: Child): Boolean {
            return oldItem == newItem
        }
    }
}