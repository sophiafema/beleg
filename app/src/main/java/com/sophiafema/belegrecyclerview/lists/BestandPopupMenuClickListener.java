package com.sophiafema.belegrecyclerview.lists;

import android.provider.SyncStateContract;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sophiafema.belegrecyclerview.R;

public class BestandPopupMenuClickListener implements PopupMenu.OnMenuItemClickListener, android.widget.PopupMenu.OnMenuItemClickListener {

    private int position;

    public BestandPopupMenuClickListener(int position) {
        this.position = position;
    }

    /**
     * Handle actions on Item click
     * @param menuItem
     * @return
     */
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.Not_interasted_catugury:
                return true;
            case R.id.No_interasted:
                return true;

            default:
        }
        return false;
    }
}
