package ar.edu.ips.aus.seminario2.tetrominos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class GameOverDialog extends DialogFragment {

    private final Activity callingActivity;
    int var;

    public GameOverDialog(Activity activity, int variable) {
        this.callingActivity = activity;
        this.var = variable;


    }

    // TODO TP1 implement restart GameMainActivity
    @NonNull
    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if(var == 1){
            builder.setMessage(R.string.new_high_score)
                    .setTitle(R.string.game_over_message);
        }
        builder.setTitle(R.string.game_over_message)
                .setPositiveButton(R.string.restart_game, (dialog, which) -> {
                    Intent reset_intent = new Intent(callingActivity, GameMainActivity.class);
                    startActivity(reset_intent);
                    callingActivity.finish();
                })
                .setNegativeButton(R.string.exit_game, (dialog, which) -> {
                    callingActivity.finish();
                });


        return builder.create();
    }
}
