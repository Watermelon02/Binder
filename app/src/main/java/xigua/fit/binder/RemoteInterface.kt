package xigua.fit.binder

import android.os.IBinder
import android.os.IInterface
import android.util.Log

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/1 09:08
 */
interface RemoteInterface:IInterface {
    fun sendMessage(string: String)
}