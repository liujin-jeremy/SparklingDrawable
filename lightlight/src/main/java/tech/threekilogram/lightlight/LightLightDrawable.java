package tech.threekilogram.lightlight;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

/**
 * @author Liujin 2019/4/3:15:04:11
 */
public class LightLightDrawable extends Drawable {

      private Paint          mPaint      = new Paint( Paint.ANTI_ALIAS_FLAG );
      private LinearGradient mGradient;
      /**
       * 闪亮的颜色
       */
      private int            mCoverColor = Color.parseColor( "#80ff8c00" );
      private Matrix         mMatrix     = new Matrix();
      private int            mDx;
      /**
       * 速度,cover每次增加的距离
       */
      private int            mSpeed      = 10;

      public LightLightDrawable ( ) {

            mPaint.setStyle( Style.FILL );
            mPaint.setColor( Color.BLACK );
      }

      @Override
      public void draw ( Canvas canvas ) {

            Rect bounds = getBounds();
            int width = bounds.width();
            int height = bounds.height();

            if( mGradient == null ) {

                  int count = 6;
                  int[] colors = new int[ count ];
                  colors[ 0 ] = mCoverColor;
                  for( int i = 1; i < colors.length; i++ ) {
                        colors[ i ] = Color.TRANSPARENT;
                  }
                  float[] positions = new float[ count ];
                  for( int i = 0; i < positions.length; i++ ) {
                        positions[ i ] = i * ( 1f / count );
                  }

                  float y1 = (float) ( Math.tan( Math.toRadians( 15 ) ) * width );
                  mGradient = new LinearGradient(
                      0, 0,
                      width, y1,
                      colors,
                      positions,
                      TileMode.MIRROR
                  );
            }

            // 移动shader
            mMatrix.reset();
            mDx += mSpeed;
            mDx %= 2 * width;
            mMatrix.setTranslate( mDx, 0 );
            mGradient.setLocalMatrix( mMatrix );

            mPaint.setShader( mGradient );

            canvas.drawRect( 0, 0, width, height, mPaint );

            invalidateSelf();
      }

      @Override
      public void setAlpha ( int alpha ) {

            mPaint.setAlpha( alpha );
      }

      @Override
      public void setColorFilter ( ColorFilter colorFilter ) {

            mPaint.setColorFilter( colorFilter );
      }

      @Override
      public int getOpacity ( ) {

            return Color.TRANSPARENT;
      }

      public void setCoverColor ( int coverColor ) {

            mCoverColor = coverColor;

            if( mGradient != null ) {
                  int count = 6;
                  int[] colors = new int[ count ];
                  colors[ 0 ] = mCoverColor;
                  for( int i = 1; i < colors.length; i++ ) {
                        colors[ i ] = Color.TRANSPARENT;
                  }
                  float[] positions = new float[ count ];
                  for( int i = 0; i < positions.length; i++ ) {
                        positions[ i ] = i * ( 1f / count );
                  }

                  int width = getBounds().width();
                  float y1 = (float) ( Math.tan( Math.toRadians( 15 ) ) * width );
                  mGradient = new LinearGradient(
                      0, 0,
                      width, y1,
                      colors,
                      positions,
                      TileMode.MIRROR
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
