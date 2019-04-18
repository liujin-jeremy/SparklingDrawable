package tech.threekilogram.sparkling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;

/**
 * @author Liujin 2019/4/3:14:39:47
 */
public class LightLightTextView extends android.support.v7.widget.AppCompatTextView {

      private LinearGradient mGradient;
      private Matrix         mMatrix;
      /**
       * 闪亮的颜色
       */
      private int            mCoverColor = Color.parseColor( "#ff8c00" );
      private int            mDx;
      /**
       * 速度,cover每次增加的距离
       */
      private int            mSpeed      = 5;

      public LightLightTextView ( Context context ) {

            super( context );
            init();
      }

      public LightLightTextView ( Context context, AttributeSet attrs ) {

            super( context, attrs );
            init();
      }

      public LightLightTextView ( Context context, AttributeSet attrs, int defStyleAttr ) {

            super( context, attrs, defStyleAttr );
            init();
      }

      private void init ( ) {

            mMatrix = new Matrix();
      }

      @Override
      protected void onDraw ( Canvas canvas ) {

            if( mGradient == null ) {
                  int textColor = getCurrentTextColor();
                  mGradient = new LinearGradient(
                      0, 0,
                      getWidth(), getHeight(),
                      new int[]{ textColor, textColor, mCoverColor, textColor, textColor },
                      new float[]{ 0, 0.25f, 0.5f, 0.75f, 1f },
                      TileMode.REPEAT
                  );
            }

            // 移动shader
            mMatrix.reset();
            mDx += mSpeed;
            int width = getWidth();
            mDx %= width;
            mMatrix.setTranslate( mDx, 0 );
            mGradient.setLocalMatrix( mMatrix );

            // 设置shader
            TextPaint paint = getPaint();
            paint.setShader( mGradient );

            super.onDraw( canvas );

            // 不断刷新
            invalidate();
      }

      public void setCoverColor ( int coverColor ) {

            mCoverColor = coverColor;

            if( mGradient != null ) {
                  int textColor = getCurrentTextColor();
                  mGradient = new LinearGradient(
                      0, 0,
                      getWidth(), getHeight(),
                      new int[]{ textColor, textColor, mCoverColor, textColor, textColor },
                      new float[]{ 0, 0.25f, 0.5f, 0.75f, 1f },
                      TileMode.REPEAT
                  );
            }
      }

      public int getCoverColor ( ) {

            return mCoverColor;
      }

      public void setSpeed ( int speed ) {

            mSpeed = speed;
      }

      public int getSpeed ( ) {

            return mSpeed;
      }
}
