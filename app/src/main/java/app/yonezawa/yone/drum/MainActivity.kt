package app.yonezawa.yone.drum

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {

    //SoundPoolの変数宣言（音楽を鳴らすために必要）
    private lateinit var mSoundPool: SoundPool

    //音楽を区別するための変数を配列で用意
    private lateinit var mSoundID: Array<Int?>

    private val mSoundResource = arrayOf(
            R.raw.cymbal1,
            R.raw.cymbal2,
            R.raw.cymbal3,
            R.raw.tom1,
            R.raw.tom2,
            R.raw.tom3,
            R.raw.hihat,
            R.raw.snare,
            R.raw.bass
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build()
        mSoundPool = SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(mSoundResource.size)
                .build()

        mSoundID = arrayOfNulls(mSoundResource.size)
        //Soundpoolをロード
        for (i in 0..(mSoundResource.size - 1)) {
            //アクティビティ情報（コンテキスト）、第二引数：音楽ファイルの名前、第三引数：１
            mSoundID[i] = mSoundPool.load(applicationContext, mSoundResource[i], 0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        //アプリを閉じるタイミングでSoundPoolを終了させて音楽停止
        mSoundPool.release()

    }

    //onClickメソッドの処理
    fun cymbal1(view: View){
        if (mSoundID[0] !=null){
            mSoundPool.play(mSoundID[0] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }

    fun cymbal2(view: View) {
        if (mSoundID[0] !=null){
            mSoundPool.play(mSoundID[1] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }

    fun cymbal3(view: View) {
        if (mSoundID[0] !=null){
            mSoundPool.play(mSoundID[2] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }

    fun tom1(view: View) {
        if (mSoundID[0] !=null){
            mSoundPool.play(mSoundID[3] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }

    fun tom2(view: View) {
        if (mSoundID[0] !=null){
                mSoundPool.play(mSoundID[4] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }


    fun tom3(view: View) {
        if (mSoundID[0] !=null){
            mSoundPool.play(mSoundID[5] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }

    fun hihat(view: View) {
        if (mSoundID[0] !=null){
            mSoundPool.play(mSoundID[6] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }

    fun snare(view: View){
        if (mSoundID[0] !=null){
            mSoundPool.play(mSoundID[7] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }

    fun bass(view: View){
        if (mSoundID[0] !=null){
            mSoundPool.play(mSoundID[8] as Int, 1.0F,1.0F,0,0,1.0F)
        }

    }

}