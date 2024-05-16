package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PessoaAdapter(val context: Context, val list: ArrayList<UserModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.list, p2, false)

        view.findViewById<TextView>(R.id.tvNome).text = "Nome: ${list[p0].nome}"
        view.findViewById<TextView>(R.id.tvUser).text = "User: ${list[p0].username}"

        return view
    }
}