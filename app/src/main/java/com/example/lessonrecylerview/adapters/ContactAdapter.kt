package com.example.lessonrecylerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonrecylerview.R
import com.example.lessonrecylerview.databinding.ItemContactBinding
import com.example.lessonrecylerview.models.Contact

class ContactAdapter(var list: ArrayList<Contact>, var contactService: ContactService) :
    RecyclerView.Adapter<ContactAdapter.MySecondViewHolder>() {
    inner class MySecondViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(contact: Contact, position: Int) {
            val bind = ItemContactBinding.bind(itemView)
            bind.tv.text = "${contact.name} ${contact.number}"

            bind.linear.setOnClickListener {
                contactService.myClickListener(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MySecondViewHolder {
        return MySecondViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MySecondViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ContactService {
        fun myClickListener(position: Int)
    }
}