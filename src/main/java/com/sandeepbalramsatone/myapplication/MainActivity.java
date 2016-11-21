package com.sandeepbalramsatone.myapplication;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.Player;
import com.google.appinventor.components.runtime.Slider;



public class MainActivity extends Form implements HandlesEventDispatching {

    // Creating the components for the application Ex Button and non-visible component Player
    // to play sound .
    private Button Button1;
    private Player player1;
    private Image Image1;
    private Boolean PlayerFlag = false;

    //Adding sound Slider
    private Slider slider1;
    public Boolean getPlayerFlag() {
        return PlayerFlag;
    }

    public void setPlayerFlag(Boolean playerFlag) {
        PlayerFlag = playerFlag;
    }

    // Define function is used to initialize the components .
    @Override
    protected void $define() {
        //Button is initialised
        Button1 = new Button(this);
        Button1.BackgroundColor(Component.COLOR_CYAN);
        Button1.Enabled(true);
        Button1.FontBold(true);
        Button1.FontItalic(true);
        Button1.FontSize(20.0f);
        Button1.FontTypeface(Component.TYPEFACE_MONOSPACE);
        Button1.Height(Component.LENGTH_PREFERRED);
        Button1.Width(LENGTH_FILL_PARENT);
        Button1.Text("Play");
        Button1.TextAlignment(Component.ALIGNMENT_CENTER);
        Button1.TextColor(Component.COLOR_BLACK);
        //Player is initialized
        player1 = new Player(this);
        player1.Source("http://uk2.internet-radio.com:30252/");
        //Image is initialized
        Image1 = new Image(this);
        Image1.Picture("icon.png");
        Image1.Height(LENGTH_FILL_PARENT);
        Image1.Width(LENGTH_FILL_PARENT);
        Image1.Visible(true);
        EventDispatcher.registerEventForDelegation(this, "Play", "Click");

    }

    @Override
    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] args) {

        if( component.equals(Button1) && eventName.equals("Click") )
        {
            if (getPlayerFlag()== false){
                player1.Start();
                Button1.Text("Started");
                setPlayerFlag(true);
            }
            else{
                player1.Stop();
                Button1.Text("Stopped");
                setPlayerFlag(false);
            }
            return true;
        }
        return false;
    }

}
