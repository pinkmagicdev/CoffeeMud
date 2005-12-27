package com.planet_ink.coffee_mud.Abilities.Spells;
import com.planet_ink.coffee_mud.core.interfaces.*;
import com.planet_ink.coffee_mud.core.*;
import com.planet_ink.coffee_mud.Abilities.interfaces.*;
import com.planet_ink.coffee_mud.Areas.interfaces.*;
import com.planet_ink.coffee_mud.Behaviors.interfaces.*;
import com.planet_ink.coffee_mud.CharClasses.interfaces.*;
import com.planet_ink.coffee_mud.Commands.interfaces.*;
import com.planet_ink.coffee_mud.Common.interfaces.*;
import com.planet_ink.coffee_mud.Exits.interfaces.*;
import com.planet_ink.coffee_mud.Items.interfaces.*;
import com.planet_ink.coffee_mud.Locales.interfaces.*;
import com.planet_ink.coffee_mud.MOBS.interfaces.*;
import com.planet_ink.coffee_mud.Races.interfaces.*;


import java.util.*;


/* 
   Copyright 2000-2006 Bo Zimmerman

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
public class Spell_LowerResists extends Spell
{
	public String ID() { return "Spell_LowerResists"; }
	public String name(){return "Lower Resistance";}
	public String displayText(){return "(Lowered Resistances)";}
	public int quality(){return MALICIOUS;};
	protected int canAffectCode(){return CAN_MOBS;}
	public int classificationCode(){return Ability.SPELL|Ability.DOMAIN_ENCHANTMENT;}

	int amount=0;

	public void unInvoke()
	{
		// undo the affects of this spell
		if((affected==null)||(!(affected instanceof MOB)))
			return;
		MOB mob=(MOB)affected;
		if(canBeUninvoked())
			mob.tell("Your cold weakness is now gone.");

		super.unInvoke();

	}

	public void affectCharStats(MOB affectedMOB, CharStats affectedStats)
	{
		super.affectCharStats(affectedMOB,affectedStats);
		affectedStats.setStat(CharStats.STAT_SAVE_ACID,affectedStats.getStat(CharStats.STAT_SAVE_ACID)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_COLD,affectedStats.getStat(CharStats.STAT_SAVE_COLD)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_DISEASE,affectedStats.getStat(CharStats.STAT_SAVE_DISEASE)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_ELECTRIC,affectedStats.getStat(CharStats.STAT_SAVE_ELECTRIC)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_FIRE,affectedStats.getStat(CharStats.STAT_SAVE_FIRE)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_GAS,affectedStats.getStat(CharStats.STAT_SAVE_GAS)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_JUSTICE,affectedStats.getStat(CharStats.STAT_SAVE_JUSTICE)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_MAGIC,affectedStats.getStat(CharStats.STAT_SAVE_MAGIC)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_TRAPS,affectedStats.getStat(CharStats.STAT_SAVE_TRAPS)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_MIND,affectedStats.getStat(CharStats.STAT_SAVE_MIND)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_PARALYSIS,affectedStats.getStat(CharStats.STAT_SAVE_PARALYSIS)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_POISON,affectedStats.getStat(CharStats.STAT_SAVE_POISON)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_UNDEAD,affectedStats.getStat(CharStats.STAT_SAVE_UNDEAD)-amount);
		affectedStats.setStat(CharStats.STAT_SAVE_WATER,affectedStats.getStat(CharStats.STAT_SAVE_WATER)-amount);
	}

	public boolean invoke(MOB mob, Vector commands, Environmental givenTarget, boolean auto, int asLevel)
	{
		MOB target=getTarget(mob,commands,givenTarget);
		if(target==null) return false;

		if(!super.invoke(mob,commands,givenTarget,auto,asLevel))
			return false;

		boolean success=profficiencyCheck(mob,0,auto);
		if(success)
		{
			CMMsg msg=CMClass.getMsg(mob,target,this,affectType(auto),auto?"A shimmering unresistable field appears around <T-NAMESELF>.":"^S<S-NAME> invoke(s) a shimmering unresistable field around <T-NAMESELF>.^?");
			if(mob.location().okMessage(mob,msg))
			{
				mob.location().send(mob,msg);
				for(int a=0;a<target.numEffects();a++)
				{
					Ability A=target.fetchEffect(a);
					if((!A.isAutoInvoked())
					&&(A.canBeUninvoked())
					&&((A.classificationCode()&Ability.ALL_DOMAINS)==Ability.DOMAIN_ABJURATION))
					{
						int x=target.numEffects();
						A.unInvoke();
						if(x>target.numEffects())
							a--;
					}
				}
				amount=(mob.envStats().level()-target.envStats().level())*5;
				if(amount<5) amount=5;
				success=maliciousAffect(mob,target,asLevel,0,-1);
			}
		}
		else
			maliciousFizzle(mob,target,"<S-NAME> attempt(s) to invoke lowered resistances on <T-NAMESELF>, but fail(s).");

		return success;
	}
}
