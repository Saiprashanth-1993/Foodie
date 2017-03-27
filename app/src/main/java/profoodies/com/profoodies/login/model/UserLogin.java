/**
 * @category FoodLover
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package profoodies.com.profoodies.login.model;

import android.databinding.BaseObservable;

/**
 * Model class is used to get and set the Username and password details
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class UserLogin extends BaseObservable {

    /**
     *  Instagram Username
     */
    private String username;

    /**
     *  Password of the user
     */
    private String password;

    /**
     * Gets {@see #username}
     *
     * @return {@link #username}
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets {@see #password}
     *
     * @return {@link #password}
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to get the warning messae
     *
     * @return to show the info message in login username
     */
    public String getNameError(){
        return "Only Instagram Users are allowed";
    }

}
