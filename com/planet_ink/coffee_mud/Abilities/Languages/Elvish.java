package com.planet_ink.coffee_mud.Abilities.Languages;
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
   Copyright 2000-2008 Bo Zimmerman

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

@SuppressWarnings("unchecked")
public class Elvish extends StdLanguage
{
	public String ID() { return "Elvish"; }
	public String name(){ return "Elvish";}
	public static Vector wordLists=null;
	private static boolean mapped=false;
	public Elvish()
	{
		super();
		if(!mapped){mapped=true;
					CMLib.ableMapper().addCharAbilityMapping("All",1,ID(),false);}
	}
	public Vector translationVector(String language)
	{
		if(wordLists==null)
		{
			String[] one={"a","e","i","o","�","�","�","�"};
			String[] two={"os","vi","ne","vo","li","eh","no","ai","by","et","ce","un","il"};
			String[] three={"�na","cil","sar","tan","hel","loa","sir","hep","yur","nol","hol","qua","�th"};
			String[] four={"s�ya","qual","quel","lara","uqua","sana","yava","masse","yanna","quettaparma","manna","manan","merme","carma","harno","harne","varno","essar","saira","cilta","veuma","norta","turme","saita"};
			String[] five={"cuiva","cuina","nonwa","imire","nauta","cilta","entuc","norta","latin","l�tea","veuya","veuro","apama","hampa","nurta","firta","saira","holle","herwa","uquen","arcoa","calte","cemma","hanta","tanen"};
			String[] six={"mahtale","porisalque","hairie","tararan","ambarwa","latina","ol�tie","amawil","apacen","yavinqua","apalume","linquilea","menelwa","alassea","nurmea","parmasse","ceniril","heldasse","imirin","earina","calatengew","lapselunga","rianna","eneques"};
			wordLists=new Vector();
			wordLists.addElement(one);
			wordLists.addElement(two);
			wordLists.addElement(three);
			wordLists.addElement(four);
			wordLists.addElement(five);
			wordLists.addElement(six);
		}
		return wordLists;
	}
	private static final Hashtable hashwords=new Hashtable();
	public Hashtable translationHash(String language)
	{
		if((hashwords!=null)&&(hashwords.size()>0))
			return hashwords;
		hashwords.put("ABANDON","avarta");
		hashwords.put("ABLE","pol");
		hashwords.put("ACCOMMODATE","camta");
		hashwords.put("ACT","car");
		hashwords.put("ADAPT","camta");
		hashwords.put("ADDRESS","tengess�");
		hashwords.put("AFFECT","peresta");
		hashwords.put("AFFECTED","persana");
		hashwords.put("AFFECTION","persani�");
		hashwords.put("AFFECTIONATE","m�la");
		hashwords.put("AFTER","n�");
		hashwords.put("AGAINST","ara");
		hashwords.put("AGED","yeniquanta");
		hashwords.put("AGO","luina");
		hashwords.put("AID","resta");
		hashwords.put("ALIKE","�v�a");
		hashwords.put("ALONE","erinqua");
		hashwords.put("ALREADY","epello");
		hashwords.put("ALSO","yando");
		hashwords.put("ALTER","presto");
		hashwords.put("ALWAYS","illum�");
		hashwords.put("AMEN","n�si�");
		hashwords.put("AMONG","im�ca");
		hashwords.put("AND","ar");
		hashwords.put("ANGLE","vennass�");
		hashwords.put("ANNIVERSARY","atyen�r�");
		hashwords.put("ANSWER","dangweth");
		hashwords.put("APPARITION","ausa");
		hashwords.put("APPLIANCE","yungwa");
		hashwords.put("APPROACH","analend�");
		hashwords.put("APPROPRIATE","sati");
		hashwords.put("ARTICLE","maca");
		hashwords.put("AS","ier");
		hashwords.put("ASSEMBLE","yocar");
		hashwords.put("ATTACK","nalanta");
		hashwords.put("BEFORE","ep�");
		hashwords.put("BEGETTER","amm�");
		hashwords.put("BEGIN","yesta");
		hashwords.put("BEGINNING","yess�");
		hashwords.put("BELT","quilta");
		hashwords.put("BESIDE","apa");
		hashwords.put("BETRAY","varta");
		hashwords.put("BETRAYER","varto");
		hashwords.put("BE","nauva");
		hashwords.put("BEYOND","l�");
		hashwords.put("BLADE","maica");
		hashwords.put("BLEND","ostim�");
		hashwords.put("BLESSED","manaquenta");
		hashwords.put("BLOOM","etelotya");
		hashwords.put("BLOSSOM","ol�t�");
		hashwords.put("BOOT","saipo");
		hashwords.put("BOUND","lanya");
		hashwords.put("BOUNDS","lanwa");
		hashwords.put("BOUNDARY","taica");
		hashwords.put("BROTH","salpa");
		hashwords.put("BURDEN","c�lo");
		hashwords.put("BUT","ono");
		hashwords.put("CAN","ista");
		hashwords.put("CAT","miura");
		hashwords.put("CATCH","raita");
		hashwords.put("CENTRE","ent�");
		hashwords.put("CENTER","ent�");
		hashwords.put("CENTRAL","entya");
		hashwords.put("CERTAINLY","tancav�");
		hashwords.put("CHAIN","angwenda");
		hashwords.put("CHARACTER","ind�m�");
		hashwords.put("CHEERS","almien");
		hashwords.put("CHESS","arantyalm�");
		hashwords.put("CHESSBOARD","artapano");
		hashwords.put("CHOOSE","cil");
		hashwords.put("CHRIST","Elpino");
		hashwords.put("CIGARETTE","uscill�");
		hashwords.put("CITY","minass�");
		hashwords.put("CLEANSE","poita");
		hashwords.put("CLOAK","fanta");
		hashwords.put("CLOCK","l�ma");
		hashwords.put("CLOSED","avalatya");
		hashwords.put("CLOSENESS","aquapahti�");
		hashwords.put("CLOTHE","hap");
		hashwords.put("CLOTHING","hamp�");
		hashwords.put("COMING","tuless�");
		hashwords.put("COMPASSION","�felm�");
		hashwords.put("COMPOSE","yocar");
		hashwords.put("COMPRESS","sanga");
		hashwords.put("CONCERN","apa");
		hashwords.put("CONCERNING","p�");
		hashwords.put("CONFIRM","tancata");
		hashwords.put("CONFRONTING","nimba");
		hashwords.put("CONSONANT","n�va-tengw�");
		hashwords.put("CONSTRUCT","yocar");
		hashwords.put("CONVERSE","artaquet");
		hashwords.put("COPPER","calarus");
		hashwords.put("COURSE","ratta");
		hashwords.put("COVERING","vail�");
		hashwords.put("CURSE","racco");
		hashwords.put("DAILY","ilyar�a");
		hashwords.put("DANGER","raxal�");
		hashwords.put("DEBATE","artaquet");
		hashwords.put("DEBT","luhta");
		hashwords.put("DEBTOR","lucando");
		hashwords.put("DEEM","ndab");
		hashwords.put("DEER","arass�");
		hashwords.put("DEFENCE","ort�ri�");
		hashwords.put("DEFINED","lanwa");
		hashwords.put("DELIVER","eter�na");
		hashwords.put("DEMON","�maia");
		hashwords.put("DENSE","sangwa");
		hashwords.put("DEPRIVED","racin�");
		hashwords.put("DESCRIBE","�na");
		hashwords.put("DESIRE","n�mi�");
		hashwords.put("DESPISE","nattira");
		hashwords.put("DESTITUTE","�na");
		hashwords.put("DEVIL","�maia");
		hashwords.put("DIFFICULTY","taryass�");
		hashwords.put("DIPHTHONG","ohlon");
		hashwords.put("DISTANCE","hayass�");
		hashwords.put("DISTANCING","hail�");
		hashwords.put("DISTURB","peresta");
		hashwords.put("DIVIDE","sati");
		hashwords.put("DIVINE","eruva");
		hashwords.put("DOOR","fendass�");
		hashwords.put("DOORWAY","fendass�");
		hashwords.put("DOWN","nat");
		hashwords.put("DRAIN","suhta");
		hashwords.put("DRINK","yulm�");
		hashwords.put("DRINKER","yulmo");
		hashwords.put("DRUM","rambill�");
		hashwords.put("DYNASTY","hilyal�");
		hashwords.put("ECCLESIASTIC","hostalya");
		hashwords.put("EDGE","lanca");
		hashwords.put("EIGHTH","told�a");
		hashwords.put("ELDER","any�ro");
		hashwords.put("EMINENT","minya");
		hashwords.put("EMOTION","felm�");
		hashwords.put("EMPLOY","yuhta");
		hashwords.put("ENHANCE","han");
		hashwords.put("ENCLOSE","lanya");
		hashwords.put("END","lancass�");
		hashwords.put("ENDURE","larta");
		hashwords.put("ENFOLD","hamp�");
		hashwords.put("ENLACED","raina");
		hashwords.put("ENQUIRY","minasuri�");
		hashwords.put("ENTANGLED","rembina");
		hashwords.put("ENTER","mitta");
		hashwords.put("ENTRAP","remi");
		hashwords.put("ENTREATY","arcand�");
		hashwords.put("ERROR","mista");
		hashwords.put("ESTABLISH","tancata");
		hashwords.put("ETERNITY","oir�");
		hashwords.put("EVIL","ulka");
		hashwords.put("EXCAVATE","rosta");
		hashwords.put("EXCLUDED","satya");
		hashwords.put("EXILE","etelerro");
		hashwords.put("EXILED","etelenda");
		hashwords.put("EXTENSION","taima");
		hashwords.put("FACE","n�v�");
		hashwords.put("FACING","nimba");
		hashwords.put("FASHION","eccat");
		hashwords.put("FASTENING","tanca");
		hashwords.put("FEEL","tenya");
		hashwords.put("FEELING","tendil�");
		hashwords.put("FENCE","ettel�");
		hashwords.put("FIFTH","lemp�a");
		hashwords.put("FINGER","leps�");
		hashwords.put("FINITE","lanwa");
		hashwords.put("FIRM","talya");
		hashwords.put("FIT","camta");
		hashwords.put("FLOOD","oloiya");
		hashwords.put("FLOWER","lots�");
		hashwords.put("FLY","ramya");
		hashwords.put("FOLLOW","veuya");
		hashwords.put("FOLLOWER","veuro");
		hashwords.put("FOLLOWING","hilm�");
		hashwords.put("FOOD","sulpa");
		hashwords.put("FOOTSTOOL","sarass�");
		hashwords.put("FOR","r�");
		hashwords.put("FORCE","sahti�");
		hashwords.put("FOREBODE","apaquet");
		hashwords.put("FORESTER","apaquet");
		hashwords.put("FORGIVE","apsene");
		hashwords.put("FORLORN","�na");
		hashwords.put("FORSAKE","avarta");
		hashwords.put("FORT","minass�");
		hashwords.put("FORTRESS","arta");
		hashwords.put("FOUNTAIN","ehtel�");
		hashwords.put("FOURTH","cant�a");
		hashwords.put("FOXY","ruscu");
		hashwords.put("FROG","carpo");
		hashwords.put("FRONT","n�v�");
		hashwords.put("FULL","penquanta");
		hashwords.put("FULLNESS","quantass�");
		hashwords.put("FUR","helet");
		hashwords.put("FUTURE","apal�m�");
		hashwords.put("GARMENT","hamp�");
		hashwords.put("GATEWAY","fendass�");
		hashwords.put("GATHERING","hostal�");
		hashwords.put("GET","net");
		hashwords.put("GLOOM","nimb�");
		hashwords.put("GLORIFY","alcarya");
		hashwords.put("GNAW","nyanda");
		hashwords.put("GORGE","capi�");
		hashwords.put("GRACE","erulisse");
		hashwords.put("GRACIOUS","raina");
		hashwords.put("GRAVE","sarca");
		hashwords.put("GREET","suila");
		hashwords.put("GREETING","suili�");
		hashwords.put("GROW","lauya");
		hashwords.put("HALLOW","airita");
		hashwords.put("HARASS","tarasta");
		hashwords.put("HARD","sarda");
		hashwords.put("HARP","tanta");
		hashwords.put("HARVEST","cermi�");
		hashwords.put("HASSOCK","sarass�");
		hashwords.put("HAVE","inyen");
		hashwords.put("HAVEN","ciryapanda");
		hashwords.put("HE","s�");
		hashwords.put("HEAVE","solto");
		hashwords.put("HEAVEN","eruman");
		hashwords.put("HEM","lan�");
		hashwords.put("HERO","salyon");
		hashwords.put("HOLD","hep");
		hashwords.put("HOMELESS","avamarwa");
		hashwords.put("HONOUR","han");
		hashwords.put("HOP","lapa");
		hashwords.put("HOPE","amat�r�");
		hashwords.put("HORN","ramna");
		hashwords.put("HUNGRY","maita");
		hashwords.put("HUNT","fara");
		hashwords.put("HURL","hat");
		hashwords.put("HYMN","airelinna");
		hashwords.put("IF","ai");
		hashwords.put("IMPEDED","tapta");
		hashwords.put("IMPEL","or");
		hashwords.put("IMPELLED","horna");
		hashwords.put("IMPETUOUS","ascara");
		hashwords.put("IMPULSE","hroafelm�");
		hashwords.put("IN","mina");
		hashwords.put("INACTION","lacar�");
		hashwords.put("INADEQUATE","penya");
		hashwords.put("INCREASE","han");
		hashwords.put("INDICATE","t�a");
		hashwords.put("INDUCE","sahta");
		hashwords.put("INEVITABILITY","sangi�");
		hashwords.put("INSPIRE","mihwesta");
		hashwords.put("INSULT","ehta");
		hashwords.put("INTEND","elya");
		hashwords.put("INTO","mitta");
		hashwords.put("INUNDATE","oloiya");
		hashwords.put("INWARDS","mitta");
		hashwords.put("ISLANDER","tolloquen");
		hashwords.put("JESUS","y�sus");
		hashwords.put("JUDGE","nem");
		hashwords.put("JUDGEMENT","n�mi�");
		hashwords.put("JUMP","lapa");
		hashwords.put("JOURNEY","lend�");
		hashwords.put("KEEP","hep");
		hashwords.put("KINDLE","calta");
		hashwords.put("KINGDOM","turindi�");
		hashwords.put("KITCHEN","mastasan");
		hashwords.put("KNEAD","mascata");
		hashwords.put("LABOUR","arass�");
		hashwords.put("LACE","raiw�");
		hashwords.put("LACKING","penya");
		hashwords.put("LAMENTING","nainala");
		hashwords.put("LAST","larta");
		hashwords.put("LEAD","tulya");
		hashwords.put("LEAN","linya");
		hashwords.put("LEAP","cap");
		hashwords.put("LEARN","nolya");
		hashwords.put("LENITION","persani�");
		hashwords.put("LENITED","persana");
		hashwords.put("LIBRARY","parmass�");
		hashwords.put("LIBRARIAN","parmasson");
		hashwords.put("LIBRARIANS","parmassondi");
		hashwords.put("LIFE","cuivi�");
		hashwords.put("LIKEHOOD","�v�ass�");
		hashwords.put("LIMIT","taica");
		hashwords.put("LIMITED","lanya");
		hashwords.put("LIP","p�");
		hashwords.put("LIPS","peu");
		hashwords.put("LOFTY","ancass�a");
		hashwords.put("LONG-LIVED","yeniquanta");
		hashwords.put("LOVING","m�la");
		hashwords.put("MANTLE","fanta");
		hashwords.put("MARIA","mar�a");
		hashwords.put("MARK","talca");
		hashwords.put("MAYBE","c�");
		hashwords.put("MEAGRE","linya");
		hashwords.put("MEAN","selya");
		hashwords.put("MEET","ovanta");
		hashwords.put("MIGHTY","taura");
		hashwords.put("MIND","s�ma");
		hashwords.put("MIDDLE","entya");
		hashwords.put("MOTHER","amill�");
		hashwords.put("MOUTH","n�va");
		hashwords.put("NECESSITY","sangi�");
		hashwords.put("NET","raima");
		hashwords.put("NETTED","raina");
		hashwords.put("NETWORK","raim�");
		hashwords.put("NEWS","sinyar");
		hashwords.put("NINTH","nert�a");
		hashwords.put("NUMERAL","notess�");
		hashwords.put("OBSTINATE","taryalanca");
		hashwords.put("OIL","LIB");
		hashwords.put("OMNIFICENT","ilucara");
		hashwords.put("OMNIPOTENT","il�vala");
		hashwords.put("OMNISCIENT","iluisa");
		hashwords.put("ON","apa");
		hashwords.put("ONE","mo");
		hashwords.put("OPEN","l�ta");
		hashwords.put("OPENING","latya");
		hashwords.put("OPENNESS","l�ti�");
		hashwords.put("OPPOSED","ara");
		hashwords.put("OPPOSITE","ara");
		hashwords.put("OPPRESSION","sangar�");
		hashwords.put("OR","var");
		hashwords.put("OVER","terwa");
		hashwords.put("PASTURE","narass�");
		hashwords.put("PATH","rata");
		hashwords.put("PATHWAY","ratta");
		hashwords.put("PATRONAGE","ort�ri�");
		hashwords.put("PEACE","s�v�");
		hashwords.put("PERHAPS","qu�ta");
		hashwords.put("PERMISSION","l�v�");
		hashwords.put("PETITION","arcand�");
		hashwords.put("PHONETIC","lambel�");
		hashwords.put("PHONETICS","lambel�");
		hashwords.put("PICK","lepta");
		hashwords.put("PINETREE","sond�");
		hashwords.put("PINETREES","sondi");
		hashwords.put("PLEASE","iquista");
		hashwords.put("POET","lairemo");
		hashwords.put("POST","talca");
		hashwords.put("POUT","penga");
		hashwords.put("PRAY","arca");
		hashwords.put("PRAYER","arcand�");
		hashwords.put("PRESS","nir");
		hashwords.put("PRESSURE","sahti�");
		hashwords.put("PRICK","ehta");
		hashwords.put("PRIVACY","aquapahti�");
		hashwords.put("PRIVATE","satya");
		hashwords.put("PROMINENT","eteminya");
		hashwords.put("PROTECTION","ort�ri�");
		hashwords.put("PURPOSE","selya");
		hashwords.put("PURSUE","sac");
		hashwords.put("QUADRANGLE","cantil");
		hashwords.put("QUADRANGLES","cantildi");
		hashwords.put("QUADRANGULAR","cantilya");
		hashwords.put("QUESTION","maquetta");
		hashwords.put("QUESTIONS","maquetta");
		hashwords.put("RANSOM","nanwenda");
		hashwords.put("RAVINE","riss�");
		hashwords.put("RAVISH","amapta");
		hashwords.put("READ","cenda");
		hashwords.put("REAP","cer");
		hashwords.put("REAPING","cerm�");
		hashwords.put("REASON","tyarw�");
		hashwords.put("REDEEMER","runando");
		hashwords.put("RED-HAIRED","russa");
		hashwords.put("REGARDS","p�");
		hashwords.put("REGULATIONS","namnasta");
		hashwords.put("RELEASE","lerya");
		hashwords.put("REMOVAL","hail�");
		hashwords.put("RESEMBLANCE","�v�ass� ");
		hashwords.put("RESOLVE","indo");
		hashwords.put("RIDE","norta");
		hashwords.put("RIDGEPOLE","orpano");
		hashwords.put("RISE","tyulya");
		hashwords.put("RIVER-BED ","ratta");
		hashwords.put("RIVET","tanca");
		hashwords.put("ROBBERY","maptal�");
		hashwords.put("ROBE","vaimata");
		hashwords.put("RUSHING","ascara");
		hashwords.put("SAD","lemba");
		hashwords.put("SADNESS","nimb�");
		hashwords.put("SAIL","ramya");
		hashwords.put("SAINT","aimo");
		hashwords.put("SAPLING","nessorn�");
		hashwords.put("SCRATCH","rimp�");
		hashwords.put("SCRIBE","tecindo");
		hashwords.put("SEARCH","sac");
		hashwords.put("SEAT","hamba");
		hashwords.put("SECOND","att�a");
		hashwords.put("SEEKING","suri�");
		hashwords.put("SEEM","s�ya");
		hashwords.put("SEND","menta");
		hashwords.put("SENTIMENT","tendil�");
		hashwords.put("SEPARATE","satya");
		hashwords.put("SERVE","hilya");
		hashwords.put("SEVENTH","ots�a");
		hashwords.put("SHARPEN","laiceta");
		hashwords.put("SHE","s�");
		hashwords.put("SHUT","pahta");
		hashwords.put("SIN","naiqu�");
		hashwords.put("SINGLE","erya");
		hashwords.put("SIXTH","enqu�a");
		hashwords.put("SMILING","raina");
		hashwords.put("SNARE","remma");
		hashwords.put("SO","si�");
		hashwords.put("SOFT","muss�");
		hashwords.put("SOMEBODY","mo");
		hashwords.put("SOUP","salpa");
		hashwords.put("SPRING","celw�");
		hashwords.put("SPLINTER","sacill�");
		hashwords.put("SPY","ettirno");
		hashwords.put("STAB","ehta");
		hashwords.put("STAFF","vandil");
		hashwords.put("STALWART","talya");
		hashwords.put("STAND","tyulya");
		hashwords.put("STARTLE","capta");
		hashwords.put("STATE","indo");
		hashwords.put("STAY","norta");
		hashwords.put("STEADY","tulunca");
		hashwords.put("STIFFNESS","taryass�");
		hashwords.put("STRAY","mistana");
		hashwords.put("STREET","ratta");
		hashwords.put("STRENGTHEN","antorya");
		hashwords.put("STRENGTHENING","antoryam�");
		hashwords.put("STRIDE","telconta");
		hashwords.put("STRIPPED","racin�");
		hashwords.put("STUDY","cenya");
		hashwords.put("SUCCESSION","hilyal�");
		hashwords.put("SUIT","camta");
		hashwords.put("SUPERIOR","orohalla");
		hashwords.put("SURGE","solto");
		hashwords.put("SURVIVE","vor");
		hashwords.put("SWARD","paswa");
		hashwords.put("SYMPATHY","�felm�");
		hashwords.put("TABLE","paluhta");
		hashwords.put("TALL","ancass�a");
		hashwords.put("TAMBOURINE","rambil");
		hashwords.put("TASK","tarass�");
		hashwords.put("TEACH","saita");
		hashwords.put("TEMPTATION","�sahti�");
		hashwords.put("TENTH","quain�a");
		hashwords.put("THAT","sa");
		hashwords.put("THICK","sangwa");
		hashwords.put("THIN","linya");
		hashwords.put("THING","engw�");
		hashwords.put("THINK","sana");
		hashwords.put("THIRD","neld�a");
		hashwords.put("THIRSTY","soica");
		hashwords.put("THITHER","tanna");
		hashwords.put("THOUGHT","sanw�");
		hashwords.put("THREAD","lanya");
		hashwords.put("THRUST","nir");
		hashwords.put("THUS","si�");
		hashwords.put("TIDE","s�la");
		hashwords.put("TIGHT","sangwa");
		hashwords.put("TODAY","sinaur�");
		hashwords.put("TOMB","sarca");
		hashwords.put("TOMORROW","entaur�");
		hashwords.put("TOUCH","appa");
		hashwords.put("TOUCHING","apa");
		hashwords.put("TOUGH","sangwa");
		hashwords.put("TOUGHNESS","taryass�");
		hashwords.put("TRACK","vata");
		hashwords.put("TRAMPLE","vatta");
		hashwords.put("TRAP","remba");
		hashwords.put("TRAVERSE","tervanta");
		hashwords.put("TRESPASS","naic�");
		hashwords.put("TRESSURE","carr�a");
		hashwords.put("TRINITY","neldi�");
		hashwords.put("TROLL","torco");
		hashwords.put("TROUBLE","tarasta");
		hashwords.put("THROW","hat");
		hashwords.put("TURRET","mind�");
		hashwords.put("TWELFTH","yunqu�");
		hashwords.put("UNCOUNTED","�n�t�a");
		hashwords.put("UNICORN","eretildo");
		hashwords.put("UNITE","erta");
		hashwords.put("UNTIL","mennai");
		hashwords.put("UNWILL","avanir");
		hashwords.put("UNWISE","alasaila");
		hashwords.put("URGE","or");
		hashwords.put("URGENCY","sangi�");
		hashwords.put("USE","yuhta");
		hashwords.put("USEFULLNESS","yungw�");
		hashwords.put("USED","yunca");
		hashwords.put("VALOUR","astal");
		hashwords.put("VASSAL","neuro");
		hashwords.put("VAST","taura");
		hashwords.put("VEIL","vasar");
		hashwords.put("VENGEANCE","atacarm�");
		hashwords.put("VERDIGRIS","lairus");
		hashwords.put("VICTORY","nangw�");
		hashwords.put("VICTOR","nacil");
		hashwords.put("VIOLENT","naraca");
		hashwords.put("VOWEL","�ma-tengw�");
		hashwords.put("WAIN","lunca");
		hashwords.put("WAIT","larta");
		hashwords.put("WAKE","eccuita");
		hashwords.put("WANDER","ramya");
		hashwords.put("WANDERER","ranyar");
		hashwords.put("WANDERING","ranya");
		hashwords.put("WARE","maca");
		hashwords.put("WARM","lauta");
		hashwords.put("WAS","eng�");
		hashwords.put("WATERFALL","lantas�r�");
		hashwords.put("WATCH","cenda");
		hashwords.put("WAVE","solm�");
		hashwords.put("WHENCE","yallo");
		hashwords.put("WHERE","mass�");
		hashwords.put("WHEREBY","yanen");
		hashwords.put("WHERETO","yanna");
		hashwords.put("WHITHER","manna");
		hashwords.put("WHOSE","yava");
		hashwords.put("WHY","manan");
		hashwords.put("WILL","mend�");
		hashwords.put("WINDOW","henet");
		hashwords.put("WINDOWS","henetsi");
		hashwords.put("WINE","miruva");
		hashwords.put("WINY","m�ruva");
		hashwords.put("WING","ramna");
		hashwords.put("WISE","saila");
		hashwords.put("WITH","as");
		hashwords.put("WITHOUT","�");
		hashwords.put("WOMB","m�na");
		hashwords.put("WOOD","toa");
		hashwords.put("WRITER","tecindo");
		hashwords.put("WRITING","sarm�");
		hashwords.put("WRONG","raic�");
		hashwords.put("YES","y�");
		hashwords.put("YESTERDAY","tellaur�");
		return hashwords;
		}
	}
