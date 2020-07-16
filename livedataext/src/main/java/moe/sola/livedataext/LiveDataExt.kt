package moe.sola.livedataext

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

/**
 * author: youhuajie
 * created on: 2020/3/16 3:06 PM
 * description:
 */
fun <T> liveData(value: T? = null) = lazy {
    MutableLiveData<T>().apply {
        this.value = value
    }
}

fun <T> mutableLiveData(value: T? = null) = lazy {
    MutableLiveData<T>().apply {
        this.value = value
    }
}

fun <T> MutableLiveData<T>.invalidate() {
    this.value = this.value
}

fun <T> MutableLiveData<T>.postInvalidate() {
    postValue(this.value)
}

fun <T> MutableLiveData<T>.updateValue(t: T?) {
    if (Looper.getMainLooper().thread == Thread.currentThread()) {
        value = t
    } else {
        postValue(t)
    }
}

fun <X, Y, R> zip2(liveData1: LiveData<X>, liveData2: LiveData<Y>, zipper: (X?, Y?) -> R): LiveData<R> {
    return MediatorLiveData<R>().apply {
        addSource(liveData1) { updateValue(zipper.invoke(liveData1.value, liveData2.value)) }
        addSource(liveData2) { updateValue(zipper.invoke(liveData1.value, liveData2.value)) }
    }
}

fun <X, Y, Z, R> zip3(liveData1: LiveData<X>, liveData2: LiveData<Y>, liveData3: LiveData<Z>, zipper: (X?, Y?, Z?) -> R): LiveData<R> {
    return MediatorLiveData<R>().apply {
        addSource(liveData1) { updateValue(zipper.invoke(liveData1.value, liveData2.value, liveData3.value)) }
        addSource(liveData2) { updateValue(zipper.invoke(liveData1.value, liveData2.value, liveData3.value)) }
        addSource(liveData3) { updateValue(zipper.invoke(liveData1.value, liveData2.value, liveData3.value)) }
    }
}

fun <X, Y> LiveData<X?>.map(mapper: (X?) -> Y): LiveData<Y> {
    return Transformations.map(this) {
        mapper.invoke(it)
    }
}