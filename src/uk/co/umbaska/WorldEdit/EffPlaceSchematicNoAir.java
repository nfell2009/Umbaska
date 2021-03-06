package uk.co.umbaska.WorldEdit;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.event.Event;

/**
 * Created by Zachary on 7/11/2015.
 */
public class EffPlaceSchematicNoAir extends Effect {

    private Expression<Location> location;
    private Expression<String> schemname;

    @Override
    protected void execute(Event event){
        Location l = location.getSingle(event);
        String name = schemname.getSingle(event);
        Schematic.place(name, l, true);
    }


    @Override
    public String toString(Event event, boolean b){
        return "Place Schematic No AIR";
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
        location = (Expression<Location>) expressions[1];
        schemname = (Expression<String>) expressions[0];
        return true;
    }
}
