package edu.temple.inclassuiacvitivity

import android.R
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.content.Context
import android.widget.TextView
import androidx.core.view.setPadding

//private var TextSizeAdapter.textview: TextView

class TextSizeAdapter(_context: Context, _textSize: Array<Int>) : BaseAdapter() {
    private val textsize = _textSize
    private val context = _context

    override fun getCount(): Int {
        return textsize.count()
    }

    override fun getItem(position: Int): Any {
        return textsize[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView : TextView
        if(convertView == null){
            textView = TextView(context)
        }else{
            textView = convertView as TextView
            textView.setPadding(5,10,0,10)
        }

        textView.text = textsize[position].toString()
        textView.textSize = textsize[position].toFloat()

        return textView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        return (getView(position,convertView, parent) as TextView).apply {
            textSize = textsize[position].toFloat()
        }
    }

}