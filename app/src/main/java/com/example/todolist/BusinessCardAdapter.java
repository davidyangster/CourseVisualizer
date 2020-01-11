package com.example.todolist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BusinessCardAdapter extends BaseAdapter {
    private List<String> cardData;

    public BusinessCardAdapter(List<String> data) {
        this.cardData = data;
    }

    @Override
    public int getCount() {
        return cardData.size();
    }

    @Override
    public String getItem(int position) {
        return cardData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = getLayoutInflater().inflate(R.layout.card, parent, false);
        TextView textViewCard = (TextView) convertView.findViewById(R.id.textViewCard);
        textViewCard.setText(cardData.get(position));

        return convertView;
    }
}
