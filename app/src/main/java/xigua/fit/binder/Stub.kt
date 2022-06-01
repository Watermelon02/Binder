package xigua.fit.binder

import android.os.Binder
import android.os.IBinder
import android.os.Parcel

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/1 14:45
 */
abstract class Stub : Binder(), RemoteInterface {

    override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
        if (code == FIRST_CALL_TRANSACTION) {
            data.enforceInterface("xigua.fit.binder")
            val param = data.readString()
            sendMessage(param!!)
            reply?.writeString("success")
            return true
        }
        return super.onTransact(code, data, reply, flags)
    }

    companion object{
        fun asInterface(iBinder: IBinder?): RemoteInterface {
            val li = iBinder?.queryLocalInterface("xigua.fit.binder")//localInterface
            if (li != null&&li is RemoteInterface){
                return li
            }
            return Proxy(iBinder!!)
        }
    }

    override fun asBinder(): IBinder {
        return this
    }
}
