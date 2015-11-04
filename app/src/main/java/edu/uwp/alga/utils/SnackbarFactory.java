package edu.uwp.alga.utils;

/**
 * Copyright 2015 UW-Parkside, Harleen Kaur, Hanh Le, Francisco Mateo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

public class SnackbarFactory {

    /**
     * Prevent initiation.
     */
    private SnackbarFactory() { }

    /**
     * Creates a {@link Snackbar} with a short length.
     *
     * @param context
     * @param view
     * @param message
     * @return {@link Snackbar}
     */
    public static Snackbar create(Context context, View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        return snackbar;
    }
}
