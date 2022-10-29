package ar.edu.ips.aus.seminario2.tetrominos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;

public class PlayFieldView extends View {

    private final PlayFieldViewModel model;
    public int blockSize;

    public PlayFieldView(Context context, PlayFieldViewModel model) {
        super(context);
        this.model = model;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        // try to adjust View extension to dimensions
        if ( blockSize == 0 ) {
            blockSize = Math.min(getWidth() / PlayField.HORIZONTAL_SIZE,
                    getHeight() / PlayField.VERTICAL_SIZE);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    blockSize * PlayField.HORIZONTAL_SIZE,
                    blockSize * PlayField.VERTICAL_SIZE);
            setLayoutParams(params);
        }

        synchronized (model.game.playField) {
            int left = 0, top = 0;
            boolean[][] cells = model.playField.getCells();
            Tetromino.Shape[][] shapes = model.playField.getShapes();

            for (int y = 0; y < cells.length; y++) {
                for (int x = 0; x < cells[0].length; x++) {
                    if (cells[y][x] &&
                            shapes[y][x] != null) {
                        Bitmap bitmap = model.shapeResources.get(shapes[y][x]);
                        Rect drawArea = new Rect(left, top, left + blockSize, top + blockSize);
                        canvas.drawBitmap(bitmap, null, drawArea, null);
                    }
                    left += blockSize;
                }
                top += blockSize;
                left = 0;
            }

            left = model.game.currentPosition.x * blockSize;
            top = model.game.currentPosition.y * blockSize;
            cells = model.game.currentBlock.cells;
            Tetromino.Shape shape = model.game.currentBlock.getShape();

            for (int y = 0; y < cells.length; y++) {
                for (int x = 0; x < cells[0].length; x++) {
                    if (cells[y][x] &&
                            shape != null) {
                        Bitmap bitmap = model.shapeResources.get(shape);
                        Rect drawArea = new Rect(left, top, left + blockSize, top + blockSize);
                        canvas.drawBitmap(bitmap, null, drawArea, null);
                    }
                    left += blockSize;
                }
                top += blockSize;
                left = model.game.currentPosition.x * blockSize;
            }
        }
    }

}
