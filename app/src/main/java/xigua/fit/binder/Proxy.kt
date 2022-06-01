package xigua.fit.binder

import android.os.Binder
import android.os.IBinder
import android.os.Parcel
import android.util.Log
import java.lang.Exception

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/1 14:49
 */
class Proxy(private val remote: IBinder):RemoteInterface {

    override fun sendMessage(string: String) {
        val data = Parcel.obtain()
        val reply = Parcel.obtain()
        try {
            data.writeInterfaceToken("xigua.fit.binder")
            data.writeString(string)
            remote.transact(Binder.FIRST_CALL_TRANSACTION,data,reply,0)
            Log.d("testTag", "proxy: ${reply.readString()}")
        }catch (ex:Exception){
            Log.d("testTag", "ex:${ex.message.toString()}")
        }finally {
            reply.recycle()
            data.recycle()
        }
    }

    override fun asBinder(): IBinder {
        return remote
    }
}