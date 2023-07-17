package com.maloac.imagelistdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maloac.imagelistdemo.model.ImageObject
class MainViewModel: ViewModel() {
    private val _data: MutableLiveData<MutableList<ImageObject>> by lazy {
        MutableLiveData<MutableList<ImageObject>>(mutableListOf(ImageObject("Image Sample", imageUrl = "https://static.remove.bg/sample-gallery/graphics/bird-thumbnail.jpg")))
    }
    private val _count: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }
    val count: LiveData<Int> = _count
    val data: LiveData<MutableList<ImageObject>> = _data

    fun addData(value: ImageObject) {
        _count.value = _count.value!! + 1
        var d = _data.value
        d?.add(value)
        _data.value = d

    }

}

