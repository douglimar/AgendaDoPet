package br.com.ddmsoftware.agendadopet;

import android.content.Context;

/**
 * Created by dmoraes on 12/09/2016.
 */
public class DatabaseController {

    private CreateDatabase database;

    public DatabaseController(Context context) {

        database = new CreateDatabase(context);

    }
}
