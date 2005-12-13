package com.planet_ink.coffee_mud.Items.Basic;
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
   Copyright 2000-2005 Bo Zimmerman

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
public class StdCage extends StdContainer
{
	public String ID(){	return "StdCage";}
	public StdCage()
	{
		super();
		setName("a cage");
		setDisplayText("a cage sits here.");
		setDescription("It\\`s of solid wood construction with metal bracings.  The door has a key hole.");
		capacity=1000;
		setContainTypes(Container.CONTAIN_BODIES|Container.CONTAIN_CAGED);
		material=EnvResource.RESOURCE_OAK;
		baseGoldValue=15;
		baseEnvStats().setWeight(25);
		recoverEnvStats();
	}



	public void executeMsg(Environmental myHost, CMMsg msg)
	{
		if((msg.amITarget(this))
        &&((msg.targetMinor()==CMMsg.TYP_LOOK)||(msg.targetMinor()==CMMsg.TYP_EXAMINE)))
		{
			MOB mob=msg.source();
			if(CMLib.flags().canBeSeenBy(this,mob))
			{
				StringBuffer buf=new StringBuffer("");
				if(Util.bset(mob.getBitmap(),MOB.ATT_SYSOPMSGS))
					buf.append(ID()+"\n\rRejuv :"+baseEnvStats().rejuv()+"\n\rUses  :"+usesRemaining()+"\n\rHeight: "+baseEnvStats().height()+"\n\rAbilty:"+baseEnvStats().ability()+"\n\rLevel :"+baseEnvStats().level()+"\n\rDeath : "+dispossessionTimeLeftString()+"\n\r"+description()+"'\n\rKey  : "+keyName()+"\n\rMisc  :'"+text());
				else
					buf.append(description()+"\n\r");
				//if(msg.source().charStats().getStat(CharStats.INTELLIGENCE)>=10)
			    //    buf.append(Util.capitalize(name())+" is mostly made of a kind of "+EnvResource.MATERIAL_DESCS[(material()&EnvResource.				        response.append("\n\r"+Util.capitalize(name())+" is mostly made of a kind of "+EnvResource.MATERIAL_NOUNDESCS[(material()&EnvResource.MATERIAL_MASK)>>8].toLowerCase()+"."))>>8].toLowerCase()+".\n\r");
				if((isOpen)&&((capacity>0)||(getContents().size()>0)))
					buf.append(name()+" contains:^<!ENTITY container \""+name()+"\"^>"+(Util.bset(mob.getBitmap(),MOB.ATT_COMPRESS)?" ":"\n\r"));
				Vector newItems=new Vector();

				if(owner instanceof MOB)
				{
					MOB M=(MOB)owner;
					for(int i=0;i<M.inventorySize();i++)
					{
						Item item=M.fetchInventory(i);
						if((item!=null)&&(item.container()==this))
							newItems.addElement(item);
					}
					buf.append(CMLib.lister().lister(mob,newItems,true,"CMItem","",false,Util.bset(mob.getBitmap(),MOB.ATT_COMPRESS)));
				}
				else
				if(owner instanceof Room)
				{
					Room room=(Room)owner;
					if(room!=null)
					for(int i=0;i<room.numItems();i++)
					{
						Item item=room.fetchItem(i);
						if((item!=null)&&(item.container()==this))
							newItems.addElement(item);
					}
					buf.append(CMLib.lister().lister(mob,newItems,true,"CRItem","",false,Util.bset(mob.getBitmap(),MOB.ATT_COMPRESS)));
				}
                if(!mob.isMonster())
                    buf.append(CMProps.mxpImage(this," ALIGN=RIGHT H=70 W=70"));
				mob.tell(buf.toString());
			}
			else
				mob.tell("You can't see that!");
			for(int b=0;b<numBehaviors();b++)
			{
				Behavior B=fetchBehavior(b);
				if(B!=null)
					B.executeMsg(this,msg);
			}

			for(int a=0;a<numEffects();a++)
			{
				Ability A=fetchEffect(a);
				if(A!=null)
					A.executeMsg(this,msg);
			}
			return;
		}
		super.executeMsg(myHost,msg);
	}
}
