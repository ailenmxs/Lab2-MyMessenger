package co.edu.unipiloto.mymessenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        showMessages();
    }
    public void onSendMessage(View view) {
        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        CreateMessageActivity.messages.add(new Message(messageText, "Propietario de camión"));
        messageView.setText("");
        Intent intent = new Intent(this, CreateMessageActivity.class);
        startActivity(intent);
    }
    private void showMessages() {
        LinearLayout layout = findViewById(R.id.messages_container);
        layout.removeAllViews();
        for (Message message : CreateMessageActivity.messages) {
            TextView messageView = new TextView(this);
            messageView.setText(String.format("%s: %s", message.getSender(), message.getText()));
            layout.addView(messageView);
        }
    }
}

