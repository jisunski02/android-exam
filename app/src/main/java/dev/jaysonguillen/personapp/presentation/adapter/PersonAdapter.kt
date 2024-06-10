package dev.jaysonguillen.personapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nyxsys.personapp.databinding.ItemPersonBinding
import dev.jaysonguillen.personapp.data.model.PersonLocal

class PersonAdapter: RecyclerView.Adapter<PersonAdapter.ViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<PersonLocal>(){
        override fun areItemsTheSame(oldItem: PersonLocal, newItem: PersonLocal): Boolean {
            return oldItem.fullName == newItem.fullName
        }

        override fun areContentsTheSame(oldItem: PersonLocal, newItem: PersonLocal): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.ViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonAdapter.ViewHolder, position: Int) {
        val personData = differ.currentList[position]
        holder.bind(personData)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(private val binding: ItemPersonBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(personLocal: PersonLocal){

            Glide.with(binding.ivProfileImage.context)
                .load(personLocal.urlPicture)
                .into(binding.ivProfileImage)

            binding.tvFullName.text = personLocal.fullName
            binding.tvAddress.text = personLocal.location

            binding.btnViewDetails.setOnClickListener {
                onItemClickListener?.let {
                    it(personLocal)
                }
            }

        }
    }

    private var onItemClickListener: ((PersonLocal)->Unit)?=null

    fun setOnItemClickLister(listener: ((PersonLocal)->Unit)){
        onItemClickListener = listener
    }
    }
