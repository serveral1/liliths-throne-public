package com.lilithsthrone.game.character.persona;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.Document;

import com.lilithsthrone.controller.xmlParsing.Element;
import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.race.AbstractRace;
import com.lilithsthrone.game.character.race.AbstractSubspecies;
import com.lilithsthrone.game.character.race.Race;
import com.lilithsthrone.game.character.race.Subspecies;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Util;

/**
 * @since 0.1.0
 * @version 0.3.9.1
 * @author Innoxia
 */
public class Name {
	// Some help from behindthename.com's name lists to find unusual forms and/or same-letter names.
	// Name etymologies / explanations omitted to comply with their terms of use about redistributing their article contents.
	private static List<NameTriplet> human = (Util.newArrayListOfValues(
					new NameTriplet("Alexander", "Alex", "Alexandria"),
					new NameTriplet("Alexius", "Alex", "Alexia"),
					new NameTriplet("Alex", "Alex", "Alex"),
					new NameTriplet("Ash", "Ashe", "Ashley"),
					
					new NameTriplet("Bart", "Bailey", "Barbara"),
					new NameTriplet("Ben", "Bennie", "Bella"),
					new NameTriplet("Bridger", "Beverly", "Bridget"),
					new NameTriplet("Brian", "Brie", "Brianna"),
					new NameTriplet("Brent", "Brett", "Britta"),
					
					new NameTriplet("Carey", "Casey", "Cadence"),
					new NameTriplet("Carl", "Carol", "Caroline"),
					new NameTriplet("Cecil", "Cecil", "Cecilia"),
					new NameTriplet("Charlie", "Charlie", "Charlie"),
					new NameTriplet("Christian", "Chris", "Christine"),
					new NameTriplet("Charles", "Charlie", "Charlotte"),
					
					new NameTriplet("Daniel", "Danny", "Dani"),
					new NameTriplet("Dale", "Dana", "Diana"),
					new NameTriplet("David", "Deb", "Debbie"),
					new NameTriplet("Dean", "Devin", "Deanna"),
					
					new NameTriplet("Edward", "Eddie", "Edna"),
					new NameTriplet("Eli", "Emery", "Evelyn"),
					new NameTriplet("Elliot", "Emerson", "Elaine"),
					new NameTriplet("Emmanuel", "Manu", "Emmanuelle"),
					new NameTriplet("Emil", "Em", "Emily"),
					new NameTriplet("Evan", "Evelyn", "Evette"),
					
					new NameTriplet("Felix", "Flick", "Felicity"),
					new NameTriplet("Frank", "Frankie", "Frances"),
					new NameTriplet("Fred", "Freddie", "Frederica"),
					
					new NameTriplet("Gabe", "Gabby", "Gale"),
					new NameTriplet("George", "Georgie", "Ginger"),
					new NameTriplet("Greg", "Grey", "Grace"),
					
					new NameTriplet("Harry", "Harley", "Hailey"),
					new NameTriplet("Henry", "Hennie", "Henrietta"),
					new NameTriplet("Hank", "Hayden", "Holly"),
					
					new NameTriplet("Ian", "Indigo", "Ilia"),
					new NameTriplet("Isidore", "Izzy", "Isabelle"),

					new NameTriplet("James", "Jamie", "Jaye"),
					new NameTriplet("Jack", "Jackie", "Jacqueline"),
					new NameTriplet("Jensen", "Jackie", "Jasmine"),
					new NameTriplet("Gareth", "Jay", "Jennifer"), // Gareth, like Jennifer, is apparently from Arthurian legend; there is no male form of Jennifer
					new NameTriplet("Ian", "Jean", "Jeanne"),
					new NameTriplet("Jerome", "Jerry", "Jeri"),
					new NameTriplet("Jesse", "Jess", "Jessica"),
					new NameTriplet("John", "Jean", "Jane"),
					new NameTriplet("Joseph", "Jojo", "Josie"),

					new NameTriplet("Karl", "Karol", "Karla"),
					new NameTriplet("Kevin", "Kel", "Katie"),
					new NameTriplet("Kasper", "Kat", "Katherine"),
					new NameTriplet("Kenneth", "Kelly", "Kendra"),
					new NameTriplet("Kristopher", "Kris", "Kristie"),

					new NameTriplet("Lawrence", "Loren", "Lauren"),
					new NameTriplet("Lee", "Leigh", "Leah"),
					new NameTriplet("Leonard", "Linden", "Leah"),
					new NameTriplet("Len", "Lumi", "Laura"),
					new NameTriplet("Les", "Lesley", "Leslie"),
					new NameTriplet("Lewis", "Lou", "Louise"),
					
					new NameTriplet("Madison", "Maddy", "Madeline"),
					new NameTriplet("Mark", "Marion", "Maria"),
					new NameTriplet("Maxwell", "Max", "Maxine"),
					new NameTriplet("Melvin", "Mel", "Melissa"),
					new NameTriplet("Michael", "Micki", "Mikaela"),
					new NameTriplet("Mike", "Max", "Miranda"), // moved "Miranda" to "Randy/Randi/Miranda"
					
					new NameTriplet("Nathan", "Nat", "Natalie"),
					new NameTriplet("Nicholas", "Nicky", "Nicole"),
					new NameTriplet("Norman", "Noble", "Nora"),
					
					new NameTriplet("Oscar", "Odell", "Opal"),
					new NameTriplet("Oliver", "Oli", "Olivia"),
					
					new NameTriplet("Pat", "Patsy", "Tricia"),
					new NameTriplet("Page", "Parker", "Paige"),
					new NameTriplet("Peter", "Peyton", "Petra"),
					new NameTriplet("Phillip", "Pip", "Phoebe"),
					
					new NameTriplet("Quentin", "Quinn", "Quinta"),
					
					new NameTriplet("Randy", "Randi", "Miranda"),
					new NameTriplet("Richard", "Ricki", "Rachel"),
					new NameTriplet("Robert", "Robbie", "Robyn"),
					
					new NameTriplet("Samuel", "Sam", "Samantha"),
					new NameTriplet("Stephen", "Steph", "Stephanie"),
					new NameTriplet("Stanley", "Sam", "Stephanie"),
					new NameTriplet("Stan", "Sacha", "Summer"),
					
					new NameTriplet("Terence", "Terry", "Theresa"),
					new NameTriplet("Theodore", "Teddie", "Dora"),
					new NameTriplet("Thomas", "Tommi", "Tamsin"),
					new NameTriplet("Tim", "Temple", "Tina"),
					new NameTriplet("Tracey", "Tracy", "Tessa"),
					new NameTriplet("Tony", "Toni", "Tonya"),

					new NameTriplet("Ulysses", "Umber", "Ursula"),

					new NameTriplet("Valentin", "Val", "Valerie"),
					new NameTriplet("Vin", "Val", "Violet"),
					new NameTriplet("Victor", "Vicky", "Victoria"),
					new NameTriplet("Virgil", "Vic", "Virginia"),

					new NameTriplet("Wallace", "Wallis", "Wanda"),
					new NameTriplet("William", "Winter", "Whitney"),
					new NameTriplet("Will", "Wynne", "Willow"),
					new NameTriplet("Wynn", "Wynne", "Gwen")
	));
	
	private static List<NameTriplet> equine = (Util.newArrayListOfValues(
					new NameTriplet("Aqua", "Aqua", "Aqua"),
					
					new NameTriplet("Bramble", "Bramble", "Bramble"),

					new NameTriplet("Dasher", "Dasher", "Dasher"),
					new NameTriplet("Dazzle", "Dazzle", "Dazzle"),

					new NameTriplet("Flint", "Flint", "Flint"),
					
					new NameTriplet("Fleet", "Fleet", "Fleet"),
					
					new NameTriplet("Midnight", "Midnight", "Midnight"),
					new NameTriplet("Moonwind", "Moonwind", "Moonwind"),

					new NameTriplet("Nimbus", "Nimbus", "Nimbus"),

					new NameTriplet("Pearl", "Pearl", "Pearl"),
					new NameTriplet("Prixie", "Prixie", "Prixie"),
					
					new NameTriplet("Skyfeet", "Skyfeet", "Skyfeet"),
					new NameTriplet("Starr", "Starr", "Starr"),
					new NameTriplet("Spirit", "Spirit", "Spirit"),
					
					new NameTriplet("Thundermane", "Thundermane", "Thundermane"),
					new NameTriplet("Twilight", "Twilight", "Twilight"),
					
					new NameTriplet("Wildlight", "Wildlight", "Wildlight")));
	
	// Similar to equine names
	private static List<NameTriplet> reindeer = (Util.newArrayListOfValues(
			
			new NameTriplet("Dasher", "Dasher", "Dasher"),
			new NameTriplet("Dancer", "Dancer", "Dancer"),
			new NameTriplet("Prancer", "Prancer", "Prancer"),
			new NameTriplet("Vixen", "Vixen", "Vixen"),
			new NameTriplet("Comet", "Comet", "Comet"),
			new NameTriplet("Cupid", "Cupid", "Cupid"),
			new NameTriplet("Dunder", "Dunder", "Dunder"),
			new NameTriplet("Blixem", "Blixem", "Blixem"),
			
			new NameTriplet("Aqua", "Aqua", "Aqua"),
			
			new NameTriplet("Bramble", "Bramble", "Bramble"),

			new NameTriplet("Dasher", "Dasher", "Dasher"),
			new NameTriplet("Dazzle", "Dazzle", "Dazzle"),

			new NameTriplet("Flint", "Flint", "Flint"),
			
			new NameTriplet("Fleet", "Fleet", "Fleet"),
			
			new NameTriplet("Midnight", "Midnight", "Midnight"),
			new NameTriplet("Moonwind", "Moonwind", "Moonwind"),

			new NameTriplet("Nimbus", "Nimbus", "Nimbus"),

			new NameTriplet("Pearl", "Pearl", "Pearl"),
			new NameTriplet("Prixie", "Prixie", "Prixie"),
			
			new NameTriplet("Skyfeet", "Skyfeet", "Skyfeet"),
			new NameTriplet("Starr", "Starr", "Starr"),
			new NameTriplet("Spirit", "Spirit", "Spirit"),
			
			new NameTriplet("Thundermane", "Thundermane", "Thundermane"),
			new NameTriplet("Twilight", "Twilight", "Twilight"),
			
			new NameTriplet("Wildlight", "Wildlight", "Wildlight")));
	
	// No offence if your name is on here... x_x
	// Significantly modified with help from behindthename.com. (No more infinite Carls!)
	// Code from later on edited a bit to throw some of these names onto other NPCs.
	private static List<NameTriplet> prostitute = (Util.newArrayListOfValues(
					new NameTriplet("Arlo", "Arden", "Arleen"),
					new NameTriplet("Ambrose", "Amber", "Amber"),
					new NameTriplet("August", "Aubrey", "Autumn"),

					new NameTriplet("Baldwin", "Bambi", "Bambi"),
					new NameTriplet("Brandon", "Brandy", "Brandi"),
					new NameTriplet("Brett", "Britt", "Britney"),
					new NameTriplet("Brian", "Brynn", "Brianna"),

					new NameTriplet("Cassidy", "Cassie", "Cassandra"),
					new NameTriplet("Carl", "Charlie", "Charlene"),
					new NameTriplet("Chad", "Channing", "Chantelle"),
					new NameTriplet("Chip", "Channing", "Chloe"),
					new NameTriplet("Claudio", "Claude", "Claudia"),
					new NameTriplet("Cole", "Connie", "Courtney"),
					new NameTriplet("Chris", "Chrissie", "Crystal"),
					new NameTriplet("Casey", "Casey", "Casey"),

					new NameTriplet("Dom", "Dolly", "Dolly"),
					new NameTriplet("Devon", "Devon", "Devon"),
					new NameTriplet("Dale", "Dakota", "Dakota"),

					new NameTriplet("Emmett", "Emmalou", "Emmalou"), // Great Scott!
					
					new NameTriplet("Heath", "Heather", "Heather"),

					new NameTriplet("Jimmy", "Jeannie", "Jenny"),
					new NameTriplet("Joe", "Jo", "Jolene"),

					new NameTriplet("Kyle", "Kylie", "Kyla"),
					new NameTriplet("Ken", "Kennie", "Kendra"),
					new NameTriplet("Kris", "Kris", "Krista"),
					new NameTriplet("Kelsey", "Kelsey", "Kelsie"),

					new NameTriplet("Lawrence", "Lauren", "Lauren"),
					
					new NameTriplet("Mitch", "Misty", "Misty"),
					new NameTriplet("Mel", "Mel", "Melody"),
					new NameTriplet("Mike", "Mindy", "Mindy"),
					
					new NameTriplet("Nicky", "Nikki", "Nikki"),
					new NameTriplet("Noel", "Noel", "Noelle"),
		
					new NameTriplet("Pierce", "Phoenix", "Penelope"),
					
					new NameTriplet("Reese", "Reece", "Reba"),
					new NameTriplet("Renard", "Rene", "Renee"),
					new NameTriplet("Rudy", "Ruby", "Ruby"),

					new NameTriplet("Savannah", "Savannah", "Savannah"),
					new NameTriplet("Sam", "Sam", "Samantha"),
					new NameTriplet("Scott", "Shelby", "Scarlet"),
					new NameTriplet("Seth", "September", "Serena"),
					new NameTriplet("Shelby", "Shelby", "Shelby"),
					new NameTriplet("Shawn", "Shayne", "Shawna"),
					new NameTriplet("Sid", "Sidney", "Sierra"),

					new NameTriplet("Tammy", "Tammy", "Tammy"),
					new NameTriplet("Tate", "Tara", "Tara"),
					new NameTriplet("Taylor", "Taylor", "Taylor"),
					new NameTriplet("Tristan", "Trina", "Trina"),
					
					new NameTriplet("Vincent", "Vic", "Vixen"),
					
					new NameTriplet("Yancy", "Yorkie", "Yolanda")
		
					//new NameTriplet("Urleen", "Urleen", "Urleen") // supplanted by the Arlo/Arden/Arleen triplet - "Urleen" seems much rarer
	));
	
	public static List<NameTriplet> petNames = Util.newArrayListOfValues(
			new NameTriplet("Ace", "Abby", "Abbie"),
			new NameTriplet("Bandit", "Babe", "Bambi"),
			new NameTriplet("Champ", "Casey", "Candy"),
			new NameTriplet("Duke", "Dottie", "Duchess"),
			new NameTriplet("Ember", "Ember", "Ember"),
			new NameTriplet("Felix", "Ferris", "Foxy"),
			new NameTriplet("Gunner", "Goldie", "Goldie"),
			new NameTriplet("Indy", "Indie", "Ivy"),
			new NameTriplet("Jet", "Jewel", "Joy"),
			new NameTriplet("King", "Kipper", "Kitty"),
			new NameTriplet("Leo", "Lou", "Lola"),
			new NameTriplet("Maxwell", "Max", "Maxine"),
			new NameTriplet("Oli", "Ollie", "Olivia"),
			new NameTriplet("Pepper", "Penny", "Peaches"),
			new NameTriplet("Scout", "Sandy", "Sandy"),
			new NameTriplet("Spot", "Socks", "Sox"),
			new NameTriplet("Tex", "Tess", "Tessie"),
			new NameTriplet("Whiskey", "Whiskers", "Willow"));
	
	public static final String[] surnames = new String[] {
			"Abberline", "Abbey", "Abbis", "Abbot", "Abbott", "Abdoun", "Abel", "Abell", "Able", "Ables", "Abner", "Abney", "Abraham", "Abrahams", "Abram", "Abron", "Absher", "Abshire", "Ackley", "Acklin", "Ackroyd", "Acland", "Acres", "Acton", "Acum", "Acy", "Adam", "Adames", "Adams", "Adamson", "Adcox", "Adderley", "Addington", "Addison", "Adey", "Adkins", "Adkison", "Adlam", "Adler", "Adrian", "Adsit", "Agar", "Agee", "Agnew", "Agutter", "Ahmad", "Ahmed", "Aiken", "Aikens", "Aikin", "Ainscough", "Ainsworth", "Akers", "Akhtar", "Akin", "Akins", "Akridge", "Alban", "Albee", "Albert", "Albertson", "Albright", "Albritton", "Albro", "Albrook", "Alcock", "Alcorn", "Alcott", "Alden", "Alder", "Alderman", "Alderson", "Aldous", "Aldren", "Aldrich", "Aldridge", "Alewine", "Alexander", "Alexis", "Alford", "Alfred", "Alger", "Ali", "Alington", "Allam", "Allan", "Allbritton", "Allday", "Alldredge", "Alleine", "Allen", "Allerton", "Allfrey", "Allgood", "Alligood", "Allin", "Alling", "Allis", "Allison", "Allmon", "Alloway", "Allred", "Allsop", "Allsup", "Allyn", "Almon", "Almond", "Alsobrook", "Alsop", "Alston", "Alsup", "Altom", "Alton", "Alvey", "Alvis", "Alvord", "Ambler", "Ambrose", "Ames", "Amin", "Amison", "Ammons", "Amos", "Andersen", "Anderson", "Anderton", "Andress", "Andrew", "Andrews", "Andrus", "Angell", "Ann", "Annis", "Ansell", "Ansley", "Anson", "Anstruther", "Anthony", "Apperson", "Applebee", "Appleby", "Applegarth", "Applegate", "Appleton", "Applewhite", "Appleyard", "Applin", "Appling", "Archer", "Archibald", "Arden", "Arkwright", "Arledge", "Arlington", "Armistead", "Armitage", "Armstead", "Armstrong", "Arnett", "Arnold", "Arrison", "Arrowood", "Arrowsmith", "Arter", "Arthur", "Artist", "Asay", "Asbury", "Ash", "Ashbrook", "Ashburn", "Ashbury", "Ashby", "Ashcroft", "Ashe", "Ashfield", "Ashford", "Ashley", "Ashlock", "Ashmead", "Ashmore", "Ashton", "Ashwell", "Ashworth", "Askins", "Aslam", "Asquith", "Astbury", "Astill", "Astle", "Aston", "Astor", "Atchley", "Atherton", "Athey", "Atkin", "Atkins", "Atkinson", "Atnip", "Attaway", "Attebery", "Attenborough", "Atterberry", "Attlee", "Attwood", "Atwater", "Atwell", "Atwill", "Atwood", "Aubrey", "Audley", "Augustine", "Austen", "Austin", "Auton", "Avera", "Averill", "Avery", "Avey", "Avis", "Awkward", "Axford", "Axtell", "Aycock", "Ayers", "Aykroyd", "Aylesworth", "Ayres", "Ayriss", "Ayrton", "Ayuba", "Azbill", "Babb", "Babbitt", "Babcock", "Baber", "Babington", "Bacchus", "Baccus", "Bachelor", "Back", "Backhouse", "Backus", "Bacon", "Baddeley", "Badger", "Badgley", "Badley", "Badman", "Bagby", "Baggett", "Bagnold", "Bagwell", "Bailey", "Bailiff", "Bain", "Bainbridge", "Baines", "Baisley", "Baize", "Baker", "Bakewell", "Balch", "Balding", "Baldridge", "Baldwin", "Bale", "Bales", "Balfour", "Ball", "Ballance", "Ballard", "Balls", "Bancroft", "Bandy", "Banes", "Banfield", "Bangs", "Banker", "Banks", "Banner", "Bannerman", "Banning", "Bannister", "Banton", "Barbee", "Barber", "Barbour", "Barclay", "Barco", "Bard", "Barden", "Bardsley", "Barefield", "Barefoot", "Barfield", "Barford", "Barham", "Barker", "Barkley", "Barks", "Barlett", "Barley", "Barlow", "Barmore", "Barnaby", "Barnard", "Barnes", "Barnett", "Barnette", "Barney", "Barnhouse", "Barnum", "Barnwell", "Barr", "Barraclough", "Barratt", "Barret", "Barrett", "Barrie", "Barron", "Barrow", "Barrowman", "Barrows", "Barrus", "Barry", "Barstow", "Bartels", "Barter", "Barth", "Bartlett", "Bartley", "Barton", "Bartram", "Barwick", "Bascom", "Basham", "Basil", "Baskerville", "Baskett", "Basnight", "Bass", "Bassett", "Bassford", "Bassham", "Bastard", "Basye", "Batchelder", "Batchelor", "Bate", "Bateman", "Bates", "Bateson", "Batey", "Bath", "Batie", "Batman", "Batson", "Batt", "Batten", "Battershell", "Batterson", "Battin", "Battle", "Battles", "Battlesby", "Batton", "Batty", "Baughn", "Bax", "Baxendale", "Baxley", "Baxter", "Bayard", "Bayless", "Bayley", "Baylis", "Bayliss", "Bayne", "Baynes", "Bays", "Baze", "Beach", "Beacham", "Beadle", "Beal", "Beale", "Beall", "Beals", "Beam", "Beamer", "Beamon", "Bean", "Beane", "Bear", "Beard", "Bearden", "Beardsley", "Beasley", "Beattie", "Beaumont", "Beaver", "Beazley", "Bebee", "Beck", "Becket", "Beckett", "Beckford", "Beckham", "Beckwith", "Beckworth", "Becraft", "Becton", "Beddingfield", "Bedford", "Bedgood", "Bedingfield", "Bedwell", "Beebe", "Beech", "Beecher", "Beede", "Beedle", "Beeks", "Beeman", "Beeson", "Begum", "Belcher", "Belden", "Belew", "Belfield", "Belgrave", "Belk", "Belknap", "Bell", "Bellamy", "Bellard", "Bellis", "Bellman", "Bellos", "Bellows", "Belson", "Belt", "Belton", "Bement", "Bemis", "Bence", "Bench", "Benedict", "Benefield", "Benfield", "Benford", "Benge", "Benham", "Benjamin", "Benn", "Benner", "Bennet", "Bennett", "Benning", "Benningsfield", "Bennington", "Benson", "Bent", "Bentinck", "Bentley", "Benton", "Beresford", "Berkebile", "Berkeley", "Berman", "Berry", "Berryhill", "Berryman", "Bertram", "Berwick", "Bessey", "Best", "Bestor", "Bettis", "Betton", "Betts", "Betty", "Bevan", "Bevill", "Beville", "Bew", "Bewley", "Bi", "Bibi", "Bible", "Bickerstaff", "Bickerton", "Bickford", "Bickham", "Bicknell", "Biddle", "Bidwell", "Bigelow", "Bigg", "Biggerstaff", "Biggins", "Biggs", "Bighead", "Bigot", "Bigsby", "Bilby", "Biles", "Billingham", "Billings", "Billingsley", "Billington", "Bills", "Billups", "Bingham", "Binkley", "Binley", "Binns", "Birch", "Birchall", "Birchfield", "Bird", "Birdsell", "Birdsong", "Birdwell", "Birge", "Birkhead", "Birkin", "Birmingham", "Birt", "Bisbee", "Biscoe", "Bishop", "Bitsh", "Bittle", "Bixby", "Bizzell", "Black", "Blackburn", "Blacker", "Blackford", "Blacklock", "Blackmon", "Blackmore", "Blackshear", "Blackshire", "Blackson", "Blackstone", "Blackwell", "Blackwood", "Blade", "Blagg", "Blair", "Blaisdell", "Blake", "Blakeley", "Blakely", "Blakeman", "Blakemore", "Blakes", "Blakey", "Blalock", "Blamer", "Blanch", "Blanchflower", "Bland", "Blandford", "Blanding", "Blank", "Blankenship", "Blanton", "Blatchford", "Blay", "Blaylock", "Bledsoe", "Blenkinsop", "Blessed", "Blessing", "Blewett", "Bliss", "Blizzard", "Blogg", "Blood", "Bloodworth", "Bloomer", "Bloomfield", "Bloor", "Bloss", "Blossom", "Blount", "Blow", "Bloxham", "Bloxsom", "Blue", "Blumenthal", "Blundell", "Blunt", "Bly", "Blythe", "Boar", "Board", "Boardman", "Boatman", "Boatright", "Boatwright", "Bobbitt", "Bobby", "Bocock", "Bodden", "Boddie", "Boddy", "Boden", "Bodie", "Bodily", "Boggess", "Boggs", "Bohling", "Boice", "Bold", "Bolden", "Bolen", "Boles", "Bolin", "Boling", "Bolles", "Bolster", "Bolton", "Bolyard", "Boman", "Bond", "Bonds", "Bone", "Bonham", "Bonney", "Bonsall", "Booker", "Boomer", "Boon", "Boone", "Boosey", "Booth", "Boothby", "Boothe", "Boots", "Borden", "Borne", "Borrow", "Borton", "Borum", "Bosanquet", "Bosley", "Boss", "Bostick", "Boston", "Bosworth", "Botsford", "Botterill", "Bottomley", "Bottoms", "Botts", "Bouldin", "Boulton", "Boulware", "Bounds", "Bourchier", "Bourland", "Bourn", "Bourne", "Boutwell", "Bowden", "Bowen", "Bower", "Bowerman", "Bowers", "Bowes", "Bowker", "Bowlby", "Bowler", "Bowles", "Bowley", "Bowlin", "Bowling", "Bowman", "Bown", "Bowra", "Bowser", "Box", "Boxell", "Boxx", "Boyce", "Boyd", "Boyden", "Boyer", "Boyland", "Boyle", "Boynton", "Brace", "Bracewell", "Brackett", "Brackman", "Bracy", "Bradburn", "Bradbury", "Bradfield", "Bradford", "Bradham", "Bradish", "Bradley", "Bradshaw", "Bradstreet", "Bradway", "Bradwell", "Brady", "Bragdon", "Bragg", "Brain", "Brainerd", "Brainsby", "Braithwaite", "Brake", "Bramble", "Bramblett", "Bramhall", "Bramwell", "Branagan", "Branam", "Branch", "Brandon", "Brandow", "Branham", "Brann", "Brannum", "Branscum", "Branson", "Brant", "Brantley", "Branton", "Branum", "Brasfield", "Brass", "Brassfield", "Braswell", "Bratton", "Braxton", "Bray", "Brayton", "Brazell", "Brazelton", "Brazier", "Brearley", "Breece", "Breeden", "Breeding", "Breedlove", "Brennan", "Brent", "Brenton", "Brereton", "Brett", "Brewer", "Brewster", "Brickell", "Bride", "Bridge", "Bridgeford", "Bridgeforth", "Bridgeman", "Bridger", "Bridges", "Bridgewater", "Bridgman", "Bridwell", "Brierton", "Briggs", "Brigham", "Bright", "Brightman", "Brighton", "Brigman", "Briley", "Brim", "Brimage", "Brimer", "Brimley", "Brindle", "Brindley", "Brinkley", "Brinson", "Brinton", "Brisco", "Briscoe", "Bristol", "Bristow", "Britt", "Brittain", "Britten", "Brittingham", "Britton", "Brixey", "Brizendine", "Broad", "Broadbent", "Broadfoot", "Broadhead", "Broadhurst", "Broadnax", "Broadwater", "Broadway", "Broadwell", "Brock", "Brockett", "Brocklesby", "Brockway", "Brockwell", "Brodhead", "Brogden", "Brome", "Bromley", "Bronson", "Brook", "Brooke", "Brooker", "Brookes", "Brooking", "Brookins", "Brookman", "Brooks", "Brookshire", "Broom", "Broome", "Broomfield", "Broomhall", "Brothers", "Brotherton", "Brougham", "Broughton", "Brown", "Browne", "Brownell", "Browner", "Browning", "Brownlee", "Brownlow", "Brownson", "Broxson", "Broxton", "Bruce", "Brumfield", "Brumley", "Brundage", "Brunt", "Brush", "Brushwood", "Bruton", "Bryan", "Bryant", "Bryd", "Bryer", "Bryon", "Bryson", "Buck", "Buckingham", "Buckland", "Buckler", "Buckles", "Buckley", "Bucklin", "Buckmaster", "Bucknell", "Bucy", "Budd", "Buell", "Buffington", "Buffum", "Bufkin", "Buford", "Bugbee", "Bugden", "Bulkley", "Bull", "Bullard", "Bullen", "Bullied", "Bullington", "Bullins", "Bullis", "Bullock", "Bullokar", "Bulluck", "Bulmer", "Bulwer", "Bump", "Bumpers", "Bumpus", "Bumstead", "Bunce", "Bunch", "Bundy", "Bunker", "Bunn", "Bunnell", "Bunting", "Burbage", "Burbank", "Burch", "Burcham", "Burchell", "Burchett", "Burchette", "Burchfield", "Burd", "Burdett", "Burdge", "Burdick", "Burditt", "Burdzy", "Burgamy", "Burge", "Burges", "Burgess", "Burgin", "Burham", "Burke", "Burkett", "Burkhead", "Burkitt", "Burks", "Burleson", "Burley", "Burling", "Burlingame", "Burman", "Burnaby", "Burnes", "Burnett", "Burnette", "Burnham", "Burnley", "Burns", "Burnup", "Burpee", "Burr", "Burrill", "Burris", "Burrough", "Burroughs", "Burrow", "Burrowes", "Burrows", "Burse", "Burt", "Burton", "Bury", "Busby", "Busey", "Bush", "Bushnell", "Bussell", "Bussey", "Buswell", "Butcher", "Butler", "Butt", "Butterfield", "Butterworth", "Buttler", "Button", "Buttram", "Buxton", "Buzbee", "Byard", "Byars", "Bybee", "Byers", "Byfield", "Byram", "Byrd", "Byrge", "Byrne", "Byrom", "Byron", "Byrum", "Bytshe", "Bywater", "Cabble", "Cabell", "Cable", "Cade", "Cadle", "Cadre", "Cadwell", "Cady", "Cage", "Cagley", "Cain", "Caine", "Cairns", "Caitiff", "Calcote", "Caldwell", "Caley", "Calfee", "Calkins", "Callaghan", "Callender", "Callis", "Calloway", "Calthorpe", "Calvert", "Calvin", "Camberwick", "Cambridge", "Camden", "Cameron", "Campbell", "Campfield", "Candy", "Canfield", "Cann", "Canning", "Cannon", "Canter", "Canterbury", "Canton", "Cantrell", "Cantwell", "Cape", "Capel", "Capers", "Caperton", "Caple", "Capp", "Capps", "Card", "Carden", "Carder", "Carey", "Carl", "Carleton", "Carlile", "Carlisle", "Carlton", "Carlyle", "Carman", "Carmon", "Carnell", "Carpenter", "Carr", "Carraway", "Carroll", "Carrow", "Carson", "Carswell", "Carter", "Carthy", "Cartlidge", "Cartmell", "Cartwright", "Carver", "Case", "Casebolt", "Casey", "Cash", "Cassidy", "Casson", "Cast", "Caster", "Castle", "Castleberry", "Caswell", "Catchings", "Catchpole", "Cate", "Cater", "Cates", "Catlett", "Catlin", "Catmull", "Catt", "Caudill", "Caudle", "Caulkins", "Cauthen", "Cavenaugh", "Cavendish", "Cayton", "Caywood", "Cearley", "Cecil", "Chace", "Chadbourne", "Chadburn", "Chadwick", "Chaffee", "Chaffin", "Chalfant", "Chalk", "Chalker", "Challender", "Chalmers", "Chamber", "Chamberlain", "Chambers", "Chamness", "Champion", "Champlin", "Chan", "Chance", "Chancellor", "Chancey", "Chancy", "Chandler", "Channel", "Channell", "Chapel", "Chaplin", "Chapman", "Chappell", "Chapple", "Charity", "Charles", "Charleston", "Charlesworth", "Charlton", "Chase", "Chatfield", "Chatham", "Chatman", "Chatterton", "Chauhan", "Cheatwood", "Cheek", "Cheeseman", "Cheesman", "Cheever", "Cherrington", "Cherry", "Cheshire", "Chesley", "Chess", "Chesser", "Chesson", "Chewning", "Chichester", "Chick", "Chidester", "Child", "Childers", "Childs", "Chiles", "Chill", "Chilson", "Chilton", "Chimes", "Chinn", "Chipman", "Chipps", "Chittenden", "Chitty", "Chitwood", "Chivers", "Choate", "Cholmondeley", "Choudhury", "Chowdhury", "Chrisp", "Christian", "Christie", "Christmas", "Christopher", "Chubb", "Chumbley", "Chunn", "Church", "Churchfield", "Churchill", "Churchwell", "Chute", "Cilento", "Cilley", "Citizen", "Clanton", "Clapham", "Clapp", "Clare", "Clark", "Clarke", "Clarkson", "Clatterbuck", "Clavin", "Clawson", "Claxton", "Clay", "Clayborn", "Claybrook", "Claypool", "Clayson", "Clayton", "Cleaver", "Cleaves", "Cleese", "Clegg", "Clem", "Clement", "Clements", "Clemmons", "Cleveland", "Cliff", "Clifford", "Clift", "Clifton", "Climer", "Clines", "Clinton", "Clizbe", "Clopton", "Close", "Clothier", "Clough", "Clubb", "Cluff", "Coates", "Cobb", "Cobbs", "Coble", "Coburn", "Cochran", "Cocke", "Cocker", "Cockerham", "Cockett", "Cockfield", "Cockrell", "Cockrill", "Coddington", "Coe", "Coen", "Coffin", "Cofield", "Cogar", "Cogdill", "Coggin", "Coggins", "Cogswell", "Cohen", "Coit", "Coke", "Coker", "Colbert", "Colburn", "Colby", "Colclough", "Coldwell", "Cole", "Coleman", "Coles", "Coley", "Colgate", "Colley", "Collier", "Collington", "Collingwood", "Collins", "Collinson", "Collinsworth", "Collis", "Collison", "Collum", "Collyer", "Colman", "Colpitts", "Colquitt", "Colson", "Colston", "Colton", "Colvin", "Colwell", "Colyer", "Combs", "Comer", "Comfort", "Commander", "Compstock", "Compton", "Comstock", "Conder", "Condit", "Conger", "Congleton", "Conkling", "Connell", "Connolly", "Connor", "Conquest", "Constable", "Constance", "Constant", "Constantine", "Converse", "Conway", "Conyers", "Cook", "Cooke", "Cooks", "Cooksey", "Cookson", "Coolidge", "Coomber", "Coombes", "Coombs", "Coomer", "Coomes", "Cooney", "Coop", "Cooper", "Coote", "Coots", "Copas", "Copass", "Cope", "Copley", "Copp", "Coppage", "Coppedge", "Copper", "Coppin", "Coppock", "Corbett", "Corbin", "Corbitt", "Corby", "Corbyn", "Cordell", "Corder", "Cordon", "Coriam", "Coriell", "Corley", "Cornell", "Cornett", "Corney", "Corning", "Cornwall", "Cornwell", "Corp", "Corten", "Corum", "Corwin", "Cory", "Cossey", "Costello", "Coston", "Cotter", "Cottingham", "Cottle", "Cotton", "Cottril", "Cottrill", "Couch", "Couchman", "Coulson", "Coulston", "Council", "Counter", "Countess", "Countryman", "Counts", "Court", "Courts", "Cousin", "Cousins", "Covell", "Covert", "Covington", "Cowan", "Coward", "Cowart", "Cowell", "Cowgill", "Cowherd", "Cowles", "Cowley", "Cowling", "Cox", "Crabb", "Crabtree", "Cracraft", "Craddock", "Cradle", "Craft", "Crafton", "Craig", "Crampton", "Crandall", "Crane", "Cranford", "Crank", "Cranmer", "Cranshaw", "Crapper", "Crase", "Crater", "Craven", "Cravens", "Crawford", "Crawley", "Cray", "Crayton", "Creasey", "Creathouse", "Creekmore", "Creel", "Crenshaw", "Cressey", "Cresswell", "Creswell", "Crew", "Cribb", "Crick", "Criddle", "Crippen", "Crippiny", "Cripps", "Crisp", "Crispin", "Crist", "Criswell", "Critchfield", "Critchlow", "Crittenden", "Crittendon", "Crocker", "Croft", "Crofts", "Cromer", "Crompton", "Cromwell", "Crook", "Crooke", "Crooks", "Cropper", "Crosby", "Crosland", "Crosley", "Cross", "Crossfield", "Crossland", "Crossley", "Crosslin", "Crosson", "Crosswell", "Crosswhite", "Crouch", "Croucher", "Crow", "Crowe", "Crowell", "Crown", "Crowther", "Croxton", "Cruise", "Crumbley", "Crume", "Crumley", "Crumpler", "Crumpton", "Cruse", "Crutcher", "Crutchfield", "Cryer", "Cudworth", "Culbertson", "Cull", "Cullen", "Cullison", "Culpepper", "Culver", "Culverhouse", "Cumberland", "Cummings", "Cundy", "Cunningham", "Cupit", "Curd", "Cureton", "Curran", "Currie", "Curry", "Curtis", "Cushing", "Cuss", "Custer", "Custis", "Cuthbertson", "Cutler", "Cutmutton", "Cutshall", "Cutter", "Cutting", "Cutts", "Cyphers", "Cyrus", "Dabney", "Dade", "DaFoe", "Daft", "Daggett", "Dakers", "Dakin", "Dalby", "Dale", "Dales", "Daley", "Dalley", "Dalton", "Daly", "Dame", "Dampier", "Dana", "Dance", "Dancer", "Dancy", "Dandridge", "Dane", "Danforth", "Dangerfield", "Daniel", "Daniels", "Dant", "Darby", "Darbyshire", "Darden", "Dare", "Dark", "Darley", "Darling", "Darlington", "Darnall", "Darnell", "Darrell", "Darrow", "Dart", "Darwin", "Dash", "Davenport", "Davey", "Davidson", "Davies", "Davis", "Davison", "Davy", "Daw", "Dawe", "Dawes", "Dawkins", "Daws", "Dawson", "Day", "Daye", "Dayton", "de Groot", "De La Mere", "De Vine", "Deacon", "Deakin", "Deakins", "Deal", "Dean", "Dear", "Dearborn", "Dearing", "Dearman", "Deason", "Deatherage", "Deathridge", "Deaton", "Debnam", "Dedman", "Dedmon", "Dee", "Deer", "Deere", "Deering", "Deese", "DeFoe", "Delafield", "Delaney", "Delbridge", "Delk", "Dell", "Demby", "Dement", "Deming", "Denbow", "Denby", "Denham", "Denison", "Denman", "Dennett", "Denning", "Dennis", "Dennison", "Denslow", "Denson", "Dent", "Denton", "Deputy", "Derby", "Derbyshire", "Devine", "Devon", "Devonshire", "Dewberry", "Dexter", "Dhillon", "Dial", "Dibble", "Dicken", "Dickens", "Dicker", "Dickerson", "Dickey", "Dickinson", "Dickman", "Dicks", "Dickson", "Digby", "Diggle", "Diggs", "Digweed", "Dike", "Dilbeck", "Dill", "Dillard", "Dilley", "Dillingham", "Dillon", "Dimick", "Dimmick", "Dinkins", "Dinsdale", "Disbrow", "Disraeli", "Diss", "Distin", "Ditch", "Ditmore", "Diver", "Dixion", "Dixon", "Dobbins", "Dobbs", "Dobson", "Doby", "Dock", "Dockery", "Dodd", "Dodds", "Dodge", "Dodrill", "Dodson", "Doe", "Doggett", "Doherty", "Doke", "Dolan", "Dolby", "Dole", "Doll", "Donahue", "Donaldson", "Donnelly", "Donovan", "Doolittle", "Dorey", "Dorman", "Dorset", "Dorsett", "Dory", "Dossett", "Dotson", "Doty", "Double", "Doughty", "Douglas", "Douse", "Dove", "Dover", "Dow", "Dowden", "Dowe", "Dower", "Dowless", "Dowling", "Down", "Downard", "Downer", "Downes", "Downie", "Downing", "Downs", "Doxey", "Doyle", "Draggoo", "Dragon", "Drain", "Drake", "Drakeford", "Drakes", "Draper", "Draughn", "Dray", "Drayton", "Dresser", "Drew", "Driggs", "Drinkale", "Drinkall", "Drinkwater", "Driscoll", "Driver", "Drown", "Druitt", "Drummer", "Drummond", "Drury", "Dry", "Dubbs", "Ducker", "Duckett", "Duckworth", "Dudgeon", "Dudley", "Duffield", "Duffy", "Duggan", "Duke", "Dukes", "Duley", "Dumbleton", "Dunaway", "Duncan", "Dunford", "Dunham", "Dunkley", "Dunn", "Dunne", "Dunston", "Dunworth", "Durall", "Durden", "Durfee", "Durham", "Durrance", "Durrant", "Durrell", "Dutton", "Duty", "Dwight", "Dwinell", "Dyar", "Dye", "Dyer", "Dyke", "Dykes", "Dyment", "Dynes", "Dyson", "Eades", "Eads", "Eager", "Eagle", "Eakins", "Eakle", "Eames", "Earl", "Earle", "Earles", "Earley", "Earls", "Early", "Earp", "Earwood", "Easley", "Eason", "East", "Eastep", "Easter", "Easterling", "Eastham", "Eastin", "Eastland", "Eastman", "Easton", "Eastwood", "Eatmon", "Eaton", "Eaves", "Ebron", "Eccles", "Eccleston", "Eckles", "Eckley", "Eddington", "Eddins", "Eddowes", "Eddy", "Eden", "Edenfield", "Edens", "Edgar", "Edge", "Edgecomb", "Edgell", "Edgerton", "Edlin", "Edmonds", "Edmonson", "Edney", "Edson", "Edwards", "Edwardson", "Eells", "Efird", "Egan", "Egerton", "Eggleston", "Eggleton", "Elam", "Elder", "Eldred", "Eldridge", "Elem", "Eley", "Elias", "Elkington", "Elkins", "Ellard", "Ellerbe", "Ellerbee", "Ellett", "Ellingsworth", "Ellington", "Elliott", "Ellis", "Ellison", "Elliston", "Ellman", "Ells", "Ellzey", "Elmer", "Elmore", "Elms", "Elson", "Elston", "Elton", "Elwell", "Ely", "Embry", "Emerson", "Emery", "Emmanuel", "Emmons", "Emory", "Enderby", "Endicott", "England", "Engles", "English", "Engram", "Enloe", "Enlow", "Eno", "Enos", "Ensign", "Enslow", "Ensor", "Entwistle", "Epley", "Ervin", "Erwin", "Eskew", "Eskridge", "Essary", "Essex", "Estabrook", "Estep", "Estepp", "Ester", "Estes", "Estey", "Estill", "Etheredge", "Ethridge", "Eubanks", "Eure", "Evans", "Everett", "Everitt", "Evers", "Everson", "Eves", "Ewell", "Ewing", "Excell", "Exley", "Eyre", "Ezell", "Ezzell", "Fabian", "Fagg", "Fagley", "Fair", "Fairbanks", "Fairbrother", "Fairchild", "Faircloth", "Fairclough", "Fairfax", "Fairfield", "Fairless", "Fairley", "Fairman", "Fales", "Falkner", "Falls", "Fane", "Fant", "Fantom", "Farage", "Farley", "Farlow", "Farmer", "Farnham", "Farnsworth", "Farnum", "Farr", "Farrand", "Farrell", "Farrer", "Farrier", "Farrington", "Farrow", "Farwell", "Fassett", "Fatt", "Faucett", "Faulk", "Faulkingham", "Faulkner", "Fauntleroy", "Favors", "Fawcett", "Fear", "Fearn", "Fearnley", "Feather", "Featherstone", "Felch", "Felix", "Fell", "Fellows", "Felton", "Felty", "Fenimore", "Fenn", "Fennell", "Fenner", "Fenton", "Fenwick", "Ferebee", "Ferguson", "Fern", "Fernald", "Fernandes", "Ferry", "Fessenden", "Few", "Ffrench", "Fickle", "Field", "Fielden", "Fielder", "Fielding", "Fields", "Fifield", "Figg", "Filer", "Files", "Filkins", "Fillmore", "Finch", "Fincham", "Fincher", "Findlay", "Fine", "Finklea", "Finn", "Firkins", "Firth", "Fish", "Fisher", "Fitch", "Fitchett", "Fite", "Fithian", "Fitts", "FitzGerald", "FitzPatrick", "FitzRoy", "Flack", "Flagg", "Flanagan", "Flanders", "Flasher", "Fleet", "Fleetwood", "Fleming", "Flesher", "Fletcher", "Flinchum", "Flint", "Flippance", "Flood", "Flook", "Florence", "Flower", "Flowerdew", "Flowers", "Fludd", "Fluitt", "Fly", "Flynn", "Flynt", "Flythe", "Fobbs", "Fogg", "Foil", "Foley", "Folger", "Folkes", "Follansbee", "Folsom", "Foote", "Forbes", "Ford", "Fordham", "Foreman", "Forest", "Forman", "Forrest", "Forrester", "Forster", "Forsyth", "Fort", "Forth", "Fortson", "Fortune", "Forward", "Fosdick", "Foskett", "Fossett", "Foster", "Foulfish", "Foulks", "Fowler", "Fowles", "Fowlkes", "Fox", "Foxwell", "Foxworthy", "Foxx", "Foye", "Frame", "Frampton", "France", "Frances", "Francis", "Frankland", "Franklin", "Franks", "Frary", "Fraser", "Fray", "Frecklington", "Fredericks", "Freedman", "Freeland", "Freeman", "Fregoe", "French", "Fretwell", "Friar", "Friday", "Friend", "Frier", "Frierson", "Frisbee", "Frisby", "Frobisher", "Frost", "Fry", "Fryar", "Frye", "Fryer", "Fugate", "Fuggle", "Fulbright", "Fulcher", "Fulford", "Fulgham", "Fulghum", "Fullalove", "Fuller", "Fullerton", "Fullilove", "Fullington", "Fullman", "Fullwood", "Fulmer", "Furby", "Furlow", "Furness", "Furr", "Furst", "Fuson", "Fussell", "Futrell", "Gable", "Gabriel", "Gadd", "Gaddis", "Gaddy", "Gadsden", "Gage", "Gaiman", "Gaines", "Gale", "Gallagher", "Gallant", "Galley", "Gallion", "Gallo", "Gallop", "Gallup", "Galusha", "Galyean", "Gamble", "Gamblin", "Gammage", "Gammon", "Gammons", "Gandy", "Gannaway", "Gant", "Garbutt", "Gardiner", "Gardner", "Garfield", "Garland", "Garlic", "Garlick", "Garmon", "Garner", "Garnett", "Garrard", "Garraway", "Garretson", "Garrett", "Garris", "Garrison", "Garten", "Garth", "Garwood", "Gascoyne", "Gaskell", "Gaskill", "Gaskin", "Gassaway", "Gates", "Gatewood", "Gathers", "Gatlin", "Gaunt", "Gauntt", "Gawkrodger", "Gay", "Gayden", "Gaylor", "Gaylord", "Gazaway", "Gee", "Geer", "Gemmell", "Gent", "Gentle", "Gentleman", "Gentry", "George", "Gerald", "Gerrard", "Gerrish", "Gerry", "Getchell", "Getty", "Ghent", "Gholson", "Gholston", "Gibbens", "Gibbons", "Gibbs", "Giberson", "Gibson", "Giddings", "Giddy", "Gidley", "Gidney", "Gifford", "Gilbert", "Gilden", "Gilder", "Gildersleeve", "Giles", "Gilford", "Gilham", "Gilkes", "Gill", "Gillard", "Gilliam", "Gillingham", "Gillock", "Gilman", "Gilpin", "Gilson", "Gilstrap", "Gilyard", "Gipson", "Girton", "Gist", "Gitlin", "Gladden", "Gladney", "Gladstone", "Gladwell", "Glassco", "Glasscock", "Glaze", "Glazier", "Gleaton", "Gleaves", "Gledhill", "Glidden", "Glidewell", "Glines", "Gloser", "Gloster", "Glover", "Glue", "Gobble", "Godbey", "Godbold", "Godby", "Goddard", "Godfrey", "Godley", "Godsmark", "Godwin", "Goforth", "Golder", "Golding", "Goldsberry", "Goldsborough", "Goldsmith", "Goldston", "Golightly", "Golson", "Golston", "Good", "Goodale", "Goodall", "Goodbeer", "Goodchild", "Goode", "Goodell", "Goodenough", "Goodenow", "Goodfellow", "Goodfriend", "Goodheart", "Goodin", "Gooding", "Goodlow", "Goodman", "Goodnight", "Goodrich", "Goodridge", "Goodrum", "Goodson", "Goodspeed", "Goodstaff", "Goodwill", "Goodwin", "Goodwyn", "Goody", "Goodyear", "Gookins", "Gorby", "Gordon", "Gordy", "Gorrell", "Gorsuch", "Goslin", "Gossage", "Gossett", "Gotham", "Gothard", "Gotobed", "Gouge", "Gough", "Gould", "Goulding", "Gowell", "Gower", "Grace", "Grafton", "Graham", "Grainger", "Grandison", "Grange", "Granger", "Grant", "Grantham", "Granville", "Grasty", "Gratton", "Gravatt", "Graves", "Gravley", "Gray", "Grayson", "Greaves", "Greeley", "Green", "Greene", "Greenfield", "Greenhalgh", "Greenham", "Greenhaw", "Greenhill", "Greening", "Greenlee", "Greenley", "Greenly", "Greenman", "Greenough", "Greenway", "Greenwell", "Greenwood", "Greeson", "Gregg", "Greggs", "Gregory", "Gregson", "Grenville", "Gresham", "Grey", "Gribble", "Grice", "Gridley", "Griffin", "Griffiths", "Grigg", "Griggs", "Grimes", "Grimmer", "Grimmett", "Grimshaw", "Grimson", "Grinder", "Grinnell", "Grinstead", "Grisham", "Grissom", "Grist", "Griswold", "Gritton", "Grizzard", "Grizzle", "Groce", "Groom", "Grooms", "Grossman", "Grosvenor", "Grote", "Grout", "Grove", "Grover", "Groves", "Grow", "Grubbs", "Grundy", "Gudger", "Guernsey", "Guess", "Guest", "Guild", "Guilford", "Gull", "Gulledge", "Gullett", "Gulley", "Gully", "Gum", "Gumboil", "Gumm", "Gump", "Gunn", "Gunnell", "Gunner", "Guptill", "Gurney", "Gustin", "Guthridge", "Guy", "Gwillim", "Hackett", "Hackney", "Hackworth", "Hadden", "Haddix", "Haden", "Hadfield", "Hadley", "Hadlock", "Haggard", "Haggett", "Hagood", "Hagwood", "Haigh", "Haight", "Hail", "Hailey", "Haines", "Haislip", "Haith", "Hakes", "Halbert", "Halcomb", "Hale", "Hales", "Haley", "Halford", "Hall", "Hallam", "Halley", "Halliday", "Halliwell", "Hallmark", "Halloway", "Halls", "Halsell", "Halsey", "Halstead", "Halsted", "Halton", "Ham", "Hamblen", "Hamblin", "Hamby", "Hamer", "Hamilton", "Hamlett", "Hammett", "Hammock", "Hammon", "Hammond", "Hamon", "Hampshire", "Hampson", "Hampton", "Hance", "Hanchett", "Hancock", "Hand", "Handley", "Handy", "Hanes", "Hanford", "Hankerson", "Hankins", "Hankinson", "Hannaford", "Hannum", "Hanover", "Hansard", "Hanscom", "Hansell", "Hansford", "Hanshaw", "Hanson", "Harber", "Harbour", "Hard", "Hardacre", "Hardaway", "Hardcastle", "Harden", "Harder", "Hardesty", "Hardin", "Harding", "Hardman", "Hardrick", "Hardwick", "Hardy", "Hare", "Hargis", "Hargrave", "Hargraves", "Hargreaves", "Hargrove", "Haris", "Harland", "Harlow", "Harman", "Harmer", "Harmon", "Harn", "Harnden", "Harned", "Harness", "Harper", "Harrah", "Harrel", "Harrell", "Harrill", "Harriman", "Harrington", "Harris", "Harrison", "Harriss", "Harrod", "Harryman", "Hart", "Hartford", "Hartin", "Hartley", "Hartsfield", "Hartshorne", "Hartwell", "Harvard", "Harvey", "Harwell", "Harwood", "Hascoat", "Hash", "Haskett", "Haskin", "Haskins", "Haslam", "Hassan", "Hastings", "Hastins", "Haswell", "Hatch", "Hatchell", "Hatcher", "Hatchett", "Hatfield", "Hatford", "Hathaway", "Hathcock", "Hatley", "Hatter", "Hatton", "Haughton", "Haven", "Havens", "Haversham", "Hawes", "Hawke", "Hawker", "Hawkes", "Hawking", "Hawkins", "Hawks", "Hawksmoor", "Haworth", "Haws", "Hawthorne", "Hay", "Haycock", "Hayes", "Hayford", "Haygood", "Hayhurst", "Haymes", "Haymore", "Hayne", "Haynes", "Hays", "Hayter", "Hayton", "Hayward", "Haywood", "Hayworth", "Hazard", "Hazel", "Hazelrigg", "Hazeltine", "Hazelton", "Hazelwood", "Hazen", "Hazlegrove", "Hazzard", "Heacock", "Head", "Headley", "Heal", "Healey", "Healy", "Heap", "Heaps", "Heard", "Hearst", "Heater", "Heath", "Heathcock", "Heatherington", "Heaton", "Hebb", "Hedge", "Hedgepeth", "Hedges", "Hedgpeth", "Hedley", "Hegwood", "Height", "Heller", "Helms", "Helton", "Hembree", "Hemingway", "Hemphill", "Hempstead", "Henderson", "Hendon", "Henley", "Henrickson", "Henry", "Henshaw", "Hensley", "Henthorn", "Herbert", "Heritage", "Herman", "Herndon", "Herod", "Herrick", "Herrin", "Herring", "Herrington", "Herrod", "Herron", "Hersey", "Hershtik", "Hervey", "Heston", "Hewes", "Hewitt", "Hewlett", "Hey", "Heybourne", "Heyward", "Heywood", "Hibbard", "Hibbert", "Hibbs", "Hick", "Hickerson", "Hickey", "Hicklin", "Hickman", "Hickok", "Hickox", "Hicks", "Hickson", "Hiett", "Higbee", "Higby", "Higdon", "Higginbotham", "Higginbottom", "Higgins", "Higgs", "High", "Higham", "Highfield", "Highfill", "Highsmith", "Hight", "Hightower", "Higley", "Hilden", "Hildreth", "Hiles", "Hill", "Hillard", "Hiller", "Hillery", "Hilliard", "Hillier", "Hillman", "Hillock", "Hills", "Hillyard", "Hillyer", "Hilton", "Hilyard", "Himes", "Hinch", "Hinchcliffe", "Hinckley", "Hindle", "Hinds", "Hine", "Hinman", "Hinson", "Hinton", "Hird", "Hirst", "Hitch", "Hitchcock", "Hitchens", "Hite", "Hixon", "Hixson", "Hoadley", "Hoar", "Hoard", "Hoare", "Hobart", "Hobbs", "Hobby", "Hobdy", "Hobgood", "Hobson", "Hockaway", "Hodgdon", "Hodge", "Hodges", "Hodgin", "Hodgkin", "Hodgkins", "Hodgkinson", "Hodgson", "Hodson", "Hoffman", "Hogan", "Hogarth", "Hogg", "Hogge", "Hogue", "Hoisington", "Hoke", "Holbert", "Holbrook", "Holcomb", "Holdaway", "Holden", "Holder", "Holding", "Holdsworth", "Hole", "Holeman", "Holford", "Holgate", "Holiday", "Holland", "Hollandsworth", "Holles", "Holley", "Holliday", "Hollie", "Hollier", "Hollifield", "Holliman", "Hollings", "Hollingshead", "Hollingworth", "Hollins", "Hollis", "Hollister", "Holloman", "Hollomon", "Holloway", "Holly", "Holman", "Holmes", "Holston", "Holt", "Holton", "Holyfield", "Home", "Homer", "Homes", "Hone", "Honea", "Honey", "Honeycutt", "Honeywell", "Hood", "Hook", "Hooker", "Hooks", "Hooper", "Hoopes", "Hoosier", "Hooten", "Hooton", "Hoover", "Hope", "Hopes", "Hopewell", "Hopkins", "Hoppe", "Hopper", "Hopping", "Hopps", "Hopwood", "Horace", "Hordge", "Horn", "Hornbuckle", "Horne", "Horner", "Hornsby", "Horrocks", "Horsey", "Horsley", "Horton", "Hosea", "Hosford", "Hosier", "Hoskins", "Hoskinson", "Hotchkiss", "Hotham", "Houchens", "Houchins", "Hough", "Houghton", "House", "Houser", "Houseworth", "Houtchens", "Hovey", "Howard", "Howarth", "Howe", "Howell", "Howells", "Howerton", "Howery", "Howes", "Howington", "Howland", "Howle", "Howlett", "Howson", "Howton", "Howze", "Hoxie", "Hoxsie", "Hoyle", "Hoyt", "Hubbard", "Hubbell", "Hubbert", "Hubble", "Hubbs", "Hubert", "Huckabee", "Huckins", "Hucks", "Huddleston", "Hudgens", "Hudkins", "Hudnall", "Hudson", "Hudspeth", "Huffington", "Hugg", "Huggins", "Hughes", "Hughley", "Huguley", "Huitt", "Hukill", "Huling", "Hulings", "Hull", "Hulme", "Hulse", "Hulsey", "Humble", "Humphery", "Humphrey", "Humphreys", "Humphries", "Hundley", "Huneycutt", "Hungate", "Hunley", "Hunt", "Hunter", "Huntington", "Huntley", "Hurd", "Hurlburt", "Hurlbut", "Hurlbutt", "Hurley", "Hursey", "Hurst", "Hurt", "Husband", "Husk", "Huskins", "Hussain", "Husted", "Hutchings", "Hutchins", "Hutchinson", "Hutchison", "Hutt", "Hutton", "Hux", "Huxford", "Huxtable", "Hyche", "Hyde", "Hyden", "Hyland", "Hymas", "Hyson", "Iddings", "Ide", "Idle", "Iiams", "Iles", "Iliff", "Illingworth", "Imes", "Ince", "Ingalls", "Ingersoll", "Ingham", "Ingle", "Ingraham", "Ingram", "Inman", "Innocent", "Inskeep", "Insley", "Iqbal", "Irby", "Ireland", "Irving", "Irwin", "Isaac", "Isabel", "Isabell", "Isham", "Isherwood", "Islam", "Isley", "Ismay", "Isom", "Ison", "Ives", "Ivester", "Ivey", "Ivie", "Ivy", "Izzard", "Jackman", "Jacks", "Jackson", "Jacobs", "Jacox", "Jagger", "Jakeman", "Jakers", "Jakes", "James", "Jamieson", "Janes", "Janey", "Janney", "Jaqua", "Jaques", "Jarman", "Jarnagin", "Jarnigan", "Jarrett", "Jarrow", "Jarvis", "Jason", "Jasper", "Jay", "Jayne", "Jaynes", "Jeans", "Jefcoat", "Jeffcoat", "Jeffers", "Jefferson", "Jeffery", "Jeffords", "Jeffrey", "Jeffries", "Jellison", "Jenkins", "Jenkinson", "Jenks", "Jenner", "Jenney", "Jennings", "Jepson", "Jerkins", "Jermyn", "Jernigan", "Jerry", "Jersey", "Jessop", "Jessup", "Jett", "Jewell", "Jewett", "Jex", "Jiles", "Jinkins", "Jinks", "Jobe", "Joe", "John", "Johns", "Johnsey", "Johnson", "Johnston", "Johnstone", "Joiner", "Joines", "Jolley", "Jolliff", "Jonas", "Jones", "Jordan", "Jorden", "Jory", "Joseph", "Joslin", "Joslyn", "Journey", "Jowett", "Joyce", "Joyner", "Jubb", "Judd", "Jude", "Judge", "Judson", "Julian", "Jump", "Jury", "Justice", "Justis", "Justus", "Kane", "Karloff", "Kaur", "Kavanagh", "Kay", "Kaye", "Keach", "Kear", "Keathley", "Keating", "Keaton", "Keeble", "Keech", "Keel", "Keeler", "Keeling", "Keen", "Keeton", "Kelham", "Kellett", "Kellum", "Kelly", "Kelp", "Kelsey", "Kemp", "Kempton", "Kendall", "Kendrick", "Kennard", "Kennedy", "Kennerly", "Kennerson", "Kennett", "Kenny", "Kensington", "Kent", "Kentish", "Kenworthy", "Kenyon", "Kerby", "Kerfoot", "Kerler", "Kerr", "Kershaw", "Kesterson", "Ketchum", "Ketron", "Kettering", "Kettle", "Key", "Khan", "Khatun", "Kibbe", "Kidd", "Kidder", "Kidwell", "Kight", "Kilbourne", "Kilburn", "Kilby", "Killer", "Killingsworth", "Kimball", "Kimbell", "Kimber", "Kimberlin", "Kimberly", "Kimble", "Kimbrel", "Kimbrell", "Kimbro", "Kimbrough", "Kindle", "Kindred", "King", "Kingsbury", "Kingsley", "Kingston", "Kinsey", "Kinslow", "Kinsman", "Kinyon", "Kirby", "Kirk", "Kirkham", "Kirkland", "Kirkley", "Kirkman", "Kirton", "Kisser", "Kitchens", "Kite", "Kitson", "Kittredge", "Kittrell", "Kitts", "Kivett", "Kline", "Knaggs", "Knight", "Knighton", "Knights", "Knoll", "Knott", "Knotts", "Knowles", "Knowlton", "Knuckles", "Kray", "Kumar", "Kyte", "Lace", "Lacefield", "Lacer", "Lacey", "Lack", "Lackey", "Lacy", "Ladd", "Ladson", "Lake", "Lakey", "Lakin", "Lamb", "Lambdin", "Lambert", "Lamberton", "Lambeth", "Lamkin", "Lamphere", "Lampkins", "Lampley", "Lamplugh", "Lamson", "Lancaster", "Lance", "Land", "Lander", "Landers", "Landor", "Lane", "Lang", "Langdon", "Langford", "Langhorne", "Langley", "Langston", "Langton", "Langworthy", "Lanham", "Lanke", "Lankford", "Lansford", "Lapham", "Large", "Lark", "Larkin", "Larkins", "Larrabee", "Larrison", "Larry", "Laseter", "Lashbrook", "Laskey", "Lasley", "Lassiter", "Laster", "Latham", "Lathem", "Lathrop", "Latimer", "Latimore", "Lattimer", "Lattimore", "Lattin", "Lavender", "Laver", "Law", "Lawerence", "Lawhon", "Lawhorn", "Lawing", "Lawless", "Lawley", "Lawrence", "Lawrie", "Lawson", "Lawton", "Lax", "Laxson", "Laxton", "Lay", "Layfield", "Layman", "Layne", "Lazenby", "Lea", "Leach", "Leachman", "Leadbetter", "Leader", "Leadingham", "Leake", "Leaman", "Learned", "Leatham", "Leatherwood", "Leavens", "Leaver", "Ledbetter", "Ledford", "Ledger", "Ledlow", "Ledwell", "Lee", "Leech", "Leedom", "Leeds", "Leek", "Leeks", "Leeper", "Lees", "Leeson", "Leet", "Leffingwell", "Leftwich", "Legg", "Legge", "Leggett", "Leigh", "Leighton", "Leming", "Lemmon", "Lemon", "Leonard", "Lessing", "Lester", "Letchworth", "Lethbridge", "Letson", "Leverett", "Leverette", "Levett", "Levy", "Lew", "Lewis", "Lewison", "Li", "Liddell", "Light", "Lightfoot", "Lighthead", "Lightle", "Lile", "Liles", "Lilley", "Lillibridge", "Lilly", "Lincoln", "Lindley", "Lindsay", "Line", "Lines", "Link", "Linley", "Linn", "Linney", "Linscott", "Linsey", "Linsley", "Linson", "Lipford", "Lipham", "Lippincott", "Lipscomb", "Lipsey", "Lipton", "Liptrap", "Liptrot", "Lisk", "Lisle", "Lister", "Litchfield", "Litherland", "Littell", "Litten", "Litteral", "Little", "Littleboy", "Littlefield", "Littlejohn", "Littleton", "Litton", "Littrell", "Lively", "Livermore", "Liverpool", "Livesay", "Livingston", "Lloyd", "Lobb", "Lobdell", "Lock", "Locke", "Locker", "Lockett", "Lockman", "Lockwood", "Lodge", "Loftin", "Loftis", "Lofton", "Logan", "Logsdon", "Logston", "Lollis", "Lomas", "Lomax", "London", "Long", "Longacre", "Longfellow", "Longway", "Longworth", "Lonon", "Looker", "Loomis", "Loophole", "Lord", "Loring", "Lorre", "Losh", "Lothrop", "Lott", "Louden", "Loudon", "Lounsbury", "Love", "Loveall", "Loveday", "Lovejoy", "Lovelace", "Lovelady", "Loveland", "Loveless", "Lovell", "Lovely", "Lover", "Lovering", "Lovern", "Lovers", "Lovett", "Loving", "Lovings", "Low", "Lowder", "Lowe", "Lowman", "Lowndes", "Lowrance", "Lowther", "Lucas", "Luck", "Luckett", "Lucky", "Ludlow", "Ludlum", "Luff", "Lugar", "Luke", "Luker", "Lumb", "Lumley", "Lummus", "Lumpkin", "Lunceford", "Lundy", "Lunn", "Lunsford", "Lunt", "Lupton", "Lusby", "Lush", "Lusher", "Lute", "Luton", "Luttrell", "Lye", "Lyford", "Lyles", "Lyman", "Lynch", "Lynde", "Lynn", "Lyon", "Lyons", "Lytle", "Lytton", "Mabery", "Mabey", "Macaulay", "MacColl", "MacDonald", "Macey", "Machin", "Mackay", "MacKay", "MacKenzie", "Mackintosh", "Macmillan", "MacMillan", "Macy", "Madden", "Maddock", "Maddy", "Madewell", "Maggard", "Magness", "Maguire", "Maher", "Mahmood", "Maiden", "Mailman", "Maine", "Major", "Majors", "Makehate", "Makepeace", "Maker", "Makin", "Malbon", "Malbrough", "Malden", "Malik", "Malin", "Mallard", "Mallory", "Malpass", "Maltby", "Manchester", "Mangham", "Mankin", "Manley", "Manly", "Mann", "Manners", "Manning", "Manns", "Manor", "Manser", "Mansfield", "Mansir", "Manwaring", "Mapes", "Maple", "Maples", "Marable", "Marble", "Marbury", "March", "Marchant", "Marcum", "Marcus", "Marcy", "Marden", "Margerum", "Margeson", "Maris", "Mark", "Markham", "Markley", "Marks", "Markum", "Marland", "Marlar", "Marler", "Marlow", "Marple", "Marriner", "Marriott", "Marrow", "Marsden", "Marsh", "Marshall", "Marshburn", "Marson", "Marston", "Martell", "Martens", "Martin", "Martindale", "Martins", "Marvel", "Mash", "Masham", "Mashburn", "Mason", "Massengale", "Massengill", "Massey", "Massingill", "Master", "Masters", "Masterson", "Maston", "Mather", "Matherly", "Mathies", "Matney", "Matson", "Matt", "Matthew", "Matthews", "Mattocks", "Maudlin", "Maughan", "Maulden", "Mauldin", "Maxcy", "Maxey", "Maxfield", "Maxham", "Maxie", "Maxon", "Maxwell", "May", "Mayberry", "Maye", "Mayes", "Mayfield", "Mayhew", "Mayle", "Maynard", "Maynor", "Mayor", "Mays", "McAdam", "McCabe", "McCann", "McCarthy", "McCormack", "McCuaig", "McDermott", "McDonald", "McDonnell", "McEnery", "McEwan", "McGowan", "McGrath", "McGraw", "McIntosh", "McIntyre", "McKay", "McKenna", "McKenzie", "McKinley", "McLaughlin", "McLean", "McLeod", "McLoughlin", "McMahon", "McNally", "Meacham", "Meachum", "Mead", "Meade", "Meadors", "Meadows", "Meads", "Means", "Mears", "Meas", "Medders", "Medford", "Medley", "Medlin", "Medlock", "Mee", "Meek", "Meeker", "Meekins", "Meeks", "Mehta", "Meier", "Meigs", "Melbourne", "Mellen", "Mellor", "Melson", "Melton", "Mendenhall", "Menefee", "Mercer", "Meredith", "Meriwether", "Merrell", "Merriam", "Merrick", "Merrifield", "Merrill", "Merriman", "Merritt", "Merriweather", "Merry", "Merton", "Merwin", "Messer", "Metcalf", "Metcalfe", "Miah", "Michael", "Micheals", "Michell", "Mickens", "Middlebrook", "Middlebrooks", "Middleton", "Midgley", "Midyett", "Mifflin", "Miggles", "Milam", "Milburn", "Miles", "Millar", "Millard", "Miller", "Millett", "Milliner", "Millington", "Millis", "Millman", "Mills", "Millward", "Millwood", "Milne", "Milner", "Milnes", "Milroy", "Milstead", "Milton", "Mimms", "Mims", "Minchin", "Miner", "Mines", "Minor", "Minter", "Minyard", "Missildine", "Mistry", "Mitch", "Mitcham", "Mitchel", "Mitchell", "Mitchem", "Mitchum", "Mitton", "Mixer", "Mixon", "Mixson", "Moak", "Moats", "Moberly", "Mobley", "Mohamed", "Mohammed", "Molden", "Mole", "Mollett", "Molloy", "Molyneux", "Monday", "Money", "Moneypenny", "Monger", "Monk", "Monks", "Montford", "Moody", "Moon", "Mooney", "Moore", "Moran", "More", "Morefield", "Morehouse", "Moreland", "Morford", "Morgan", "Moriarty", "Morlan", "Morley", "Morrill", "Morris", "Morrison", "Morrow", "Morse", "Mortimer", "Morton", "Moseley", "Mosier", "Mosley", "Moss", "Mote", "Moton", "Mott", "Mounce", "Mount", "Mountebank", "Mounter", "Mountjoy", "Mowbray", "Mowery", "Mowrey", "Mowry", "Moxley", "Moye", "Moyle", "Much", "Mudd", "Mudge", "Mugglebee", "Muir", "Mulford", "Mullenax", "Mullenix", "Mullett", "Mullis", "Mumford", "Muncy", "Munday", "Munden", "Munford", "Munger", "Munn", "Munro", "Munsey", "Murch", "Murphy", "Murray", "Murrell", "Murrow", "Musgrave", "Musgrove", "Musselwhite", "Musson", "Mutton", "Myatt", "Myddelton", "Myers", "Myles", "Mynatt", "Myrick", "Nabors", "Nail", "Naismith", "Naples", "Napper", "Nash", "Nasworthy", "Nathan", "Nation", "Nations", "Nave", "Naylor", "Neal", "Neale", "Necessary", "Nedd", "Needham", "Needles", "Neel", "Negus", "Neighbors", "Nelms", "Nelson", "Nesbitt", "Netherton", "Netley", "Nett", "Nettles", "Nettleton", "Neville", "Nevitt", "New", "Newark", "Newberry", "Newbold", "Newborn", "Newburn", "Newbury", "Newby", "Newcomb", "Newcombe", "Newcomer", "Newell", "Newhall", "Newland", "Newman", "Newnam", "Newport", "Newsham", "Newsome", "Newson", "Newsum", "Newton", "Niblett", "Nibley", "Nichol", "Nicholas", "Nicholes", "Nicholls", "Nichols", "Nicholson", "Nickel", "Nickerson", "Nickle", "Nicks", "Nickson", "Nicols", "Night", "Nightingale", "Nipper", "Nix", "Nixon", "Noakes", "Nobbs", "Noble", "Nobles", "Noblitt", "Nock", "Nokes", "Nolan", "Noll", "Norcross", "Norfleet", "Norman", "Norrell", "Norridge", "Norris", "Norsworthy", "North", "Northcott", "Northcutt", "Northern", "Northington", "Northrup", "Norton", "Norvell", "Norwood", "Nott", "Nottingham", "Nourse", "Nowell", "Noyd", "Noyes", "Nuckols", "Nunley", "Nunn", "Nunnery", "Nurse", "Nutt", "Nuttall", "Nutter", "Nutting", "Nye", "O'Brien", "O'Connell", "O'Connor", "O'Donnell", "O'Neill", "O'Reilly", "O'Sullivan", "Oakenfold", "Oakenshaw", "Oakes", "Oakland", "Oakley", "Oakman", "Oates", "Odom", "Odoms", "Odum", "Offer", "Ogburn", "Ogden", "Olafson", "Old", "Oldaker", "Olden", "Oldfield", "Oldham", "Olds", "Oles", "Oliver", "Ollis", "Olmstead", "Olmsted", "Olney", "Olston", "Oney", "Openshaw", "Oram", "Orbison", "Orchard", "Orcutt", "Ordway", "Ore", "Organ", "Orme", "Ormes", "Ormsby", "Orr", "Orris", "Orton", "Orvis", "Orwell", "Osborn", "Osborne", "Osbourn", "Osbourne", "Osburn", "Osgood", "Osmond", "Ostler", "Oswald", "Otis", "Ott", "Ottley", "Otwell", "Ousley", "Outlaw", "Overall", "Overbay", "Overbey", "Overstreet", "Overton", "Overy", "Oviatt", "Owen", "Owenby", "Owens", "Ownby", "Owsley", "Oxford", "Oxley", "Oxnard", "Oxtoby", "Oxton", "Oxx", "Oyler", "Ozment", "Pace", "Pack", "Packard", "Packer", "Paddock", "Padgett", "Pafford", "Page", "Paige", "Pain", "Paine", "Painter", "Palin", "Palmer", "Palmerston", "Palmore", "Pancoast", "Pangburn", "Pannell", "Pape", "Paradise", "Paramore", "Pardee", "Parham", "Park", "Parke", "Parker", "Parkes", "Parkhurst", "Parkin", "Parkins", "Parkinson", "Parkison", "Parkman", "Parks", "Parman", "Parmar", "Parmelee", "Parmenter", "Parmley", "Parr", "Parramore", "Parrish", "Parrott", "Parry", "Parsley", "Parson", "Parsons", "Partin", "Partington", "Partlow", "Partney", "Parton", "Partridge", "Parvin", "Pass", "Passmore", "Patch", "Patchett", "Patel", "Paterson", "Patrick", "Patridge", "Pattern", "Patterson", "Patton", "Paul", "Pauley", "Pauling", "Paxson", "Payne", "Payson", "Payton", "Peabody", "Peace", "Peach", "Peachey", "Peacock", "Peak", "Pear", "Pearce", "Pearcy", "Pearl", "Pearman", "Pearsall", "Pearson", "Peary", "Pease", "Peavey", "Peay", "Pebworth", "Peck", "Peckham", "Peed", "Peek", "Peel", "Peele", "Peet", "Pegg", "Pegram", "Peirce", "Pelfrey", "Pelham", "Pell", "Pelley", "Pelton", "Pemberton", "Pembleton", "Pendelton", "Pender", "Pendle", "Pendleton", "Penhaligon", "Penick", "Peniston", "Penley", "Penn", "Pennell", "Penney", "Penniman", "Pennington", "Pennock", "Penny", "Pennyfeather", "Pennyworth", "Penson", "Penton", "Penwell", "People", "Percell", "Perceval", "Percival", "Percy", "Perham", "Perkins", "Perkinson", "Permenter", "Pernell", "Perrott", "Perry", "Persons", "Peters", "Peterson", "Pettengill", "Pettibone", "Pettifer", "Pettis", "Pettitt", "Pettus", "Pettway", "Petty", "Pettyjohn", "Peyton", "Phelps", "Phenix", "Philbrick", "Philbrook", "Philby", "Phillip", "Phillips", "Philpot", "Phipps", "Pickard", "Pickens", "Pickerel", "Pickerill", "Pickering", "Pickett", "Pickrell", "Pickup", "Pidgeon", "Piercy", "Pierpont", "Pierson", "Pigg", "Pigman", "Pike", "Piland", "Pilcher", "Pilgrim", "Pilkington", "Pillow", "Pillsbury", "Pinchback", "Pine", "Piner", "Pingleton", "Pingree", "Pinion", "Pink", "Pinkham", "Pinkston", "Pinner", "Pinney", "Pinnock", "Piper", "Pipes", "Pipkin", "Pippen", "Pippin", "Pisani", "Pitcher", "Pitchford", "Pitcock", "Pitkin", "Pitman", "Pitt", "Pittard", "Pittman", "Pitts", "Pixley", "Plaisted", "Plant", "Plaskett", "Platt", "Player", "Pleasant", "Pleasants", "Pledger", "Pletcher", "Plowman", "Plum", "Plumb", "Plumley", "Plummer", "Plunkett", "Poarch", "Pocket", "Pocklington", "Pocock", "Poe", "Poggs", "Poindexter", "Pointer", "Poland", "Poldark", "Polen", "Poling", "Pollard", "Polley", "Pollitt", "Polly", "Polyblank", "Pomeroy", "Pond", "Ponder", "Ponds", "Ponton", "Pool", "Poole", "Pooler", "Poor", "Poore", "Poovey", "Pope", "Popejoy", "Popham", "Poplar", "Poplin", "Porch", "Porter", "Portwood", "Posey", "Post", "Postlethwaite", "Poston", "Poteet", "Poteete", "Potter", "Potts", "Poulter", "Pound", "Pounds", "Powe", "Powell", "Power", "Powers", "Pownall", "Poyner", "Poynter", "Poythress", "Prall", "Pratt", "Pray", "Preble", "Predmore", "Preece", "Prentice", "Prentiss", "Presby", "Prescott", "Presnell", "Press", "Pressnell", "Preston", "Prestridge", "Prestwich", "Pretty", "Prettyman", "Prevo", "Prewett", "Prewitt", "Pribble", "Price", "Pricket", "Priddy", "Pride", "Pridemore", "Pridgen", "Pridgeon", "Pridmore", "Priest", "Priestley", "Prime", "Primm", "Primmer", "Primrose", "Prince", "Pring", "Printup", "Prior", "Pritchard", "Procter", "Proctor", "Proffitt", "Profitt", "Proper", "Prophet", "Prout", "Prouty", "Prude", "Pruden", "Pryde", "Pryor", "Ptolemy", "Puckett", "Puffer", "Pugh", "Pugsley", "Pullen", "Pulley", "Pullin", "Pullman", "Pulsifer", "Purcell", "Purchase", "Purdon", "Purdy", "Purington", "Purnell", "Purrington", "Purser", "Purvis", "Puryear", "Pusey", "Putman", "Putnam", "Putney", "Putt", "Pyatt", "Pyburn", "Pye", "Pyke", "Pyle", "Pyles", "Pyne", "Qualls", "Quarles", "Quartermain", "Quarterman", "Queen", "Quertermous", "Quimby", "Quincy", "Quinn", "Race", "Rackley", "Radcliff", "Radcliffe", "Radford", "Radley", "Raffles", "Raggs", "Ragland", "Ragsdale", "Rahman", "Rai", "Raiford", "Railey", "Rain", "Raine", "Raines", "Rains", "Rainwater", "Rake", "Raker", "Rakes", "Rakestraw", "Raley", "Ralls", "Ralph", "Ralston", "Ramsay", "Ramsbottom", "Ramsdell", "Rance", "Randall", "Randle", "Randles", "Randolph", "Ranger", "Ransdell", "Ransom", "Ransome", "Ranson", "Raper", "Raphael", "Rascoe", "Rash", "Rashid", "Ratcliff", "Ratcliffe", "Rathbone", "Rathbun", "Rathburn", "Ratley", "Ratliff", "Raven", "Ravenscroft", "Rawling", "Rawlings", "Rawlins", "Rawlinson", "Rawls", "Rawson", "Ray", "Raye", "Rayford", "Raymond", "Rayner", "Raynor", "Rea", "Read", "Reade", "Reader", "Reagan", "Reason", "Reaves", "Reavis", "Reay", "Record", "Rector", "Red", "Redburn", "Redding", "Reddish", "Redfield", "Redford", "Redgate", "Redgrave", "Redmon", "Redus", "Reed", "Reeder", "Rees", "Reeve", "Reeves", "Regan", "Register", "Rehman", "Reid", "Reilly", "Remington", "Render", "Renshaw", "Revell", "Revis", "Rew", "Rexford", "Reynold", "Reynolds", "Rhoades", "Rhoden", "Rhodes", "Rhymes", "Rice", "Rich", "Richard", "Richards", "Richardson", "Richarson", "Richerson", "Richeson", "Richins", "Richman", "Richmond", "Rickard", "Rickards", "Ricker", "Rickett", "Ricketts", "Rickman", "Ricks", "Riddell", "Riddle", "Rideout", "Ridgeway", "Ridgley", "Ridgway", "Riding", "Ridley", "Ridout", "Rigby", "Rigg", "Riggins", "Riggs", "Rigsby", "Riles", "Riley", "Rimes", "Rimmer", "Rines", "Ring", "Ringgold", "Ripley", "Rippeon", "Risley", "Rist", "Ritchie", "River", "Rivers", "Rives", "Rix", "Roach", "Roark", "Robb", "Robbins", "Robbs", "Roberson", "Roberts", "Robertson", "Robey", "Robie", "Robin", "Robins", "Robinson", "Robjohn", "Robotham", "Robson", "Roby", "Rochester", "Rock", "Rockett", "Rockey", "Rockhill", "Rockwell", "Rockwood", "Rodbard", "Rodden", "Roderick", "Rodgers", "Rodman", "Rodney", "Rodríguez", "Roe", "Roebuck", "Rogers", "Rogerson", "Roland", "Rolfe", "Rolle", "Roller", "Rollin", "Rollings", "Rollins", "Rolph", "Roman", "Rome", "Romney", "Romriell", "Rone", "Rook", "Rooke", "Rooks", "Room", "Rooney", "Root", "Rootes", "Roper", "Roscoe", "Rose", "Roseberry", "Roseboro", "Rosemond", "Ross", "Rossiter", "Rosson", "Rothwell", "Roughton", "Rounds", "Roundtree", "Rountree", "Rousey", "Rowbottom", "Rowe", "Rowell", "Rowland", "Rowlands", "Rowlett", "Rowley", "Rowling", "Royall", "Royals", "Royce", "Royer", "Royster", "Ruby", "Ruck", "Rudd", "Rudder", "Rudge", "Rudman", "Ruff", "Ruffin", "Rufus", "Rugg", "Ruggles", "Rumble", "Rumley", "Rundell", "Rundle", "Runnels", "Rupert", "Rush", "Rushton", "Russ", "Russell", "Rutherford", "Rutland", "Rutledge", "Rutt", "Rutter", "Ryals", "Ryan", "Ryder", "Ryland", "Ryman", "Rymer", "Sabin", "Sabine", "Sackett", "Saddler", "Sadler", "Safford", "Sage", "Sager", "Sagor", "Sales", "Salisbury", "Sallee", "Salley", "Sallis", "Salmon", "Salsbury", "Salter", "Salyer", "Salyers", "Sam", "Sammons", "Samples", "Sampson", "Sams", "Samson", "Samuel", "Sanborn", "Sandefur", "Sandell", "Sanders", "Sanderson", "Sandford", "Sandhu", "Sandidge", "Sandifer", "Sandiford", "Sandridge", "Sands", "Sandy", "Sanford", "Sankey", "Sanor", "Sansbury", "Sansom", "Sappington", "Sargent", "Sarin", "Sarratt", "Sarrett", "Sartain", "Sartin", "Sartor", "Satchell", "Sater", "Saterfiel", "Satterlee", "Satterthwaite", "Satterwhite", "Sauders", "Saulsbury", "Saunders", "Savage", "Savell", "Savile", "Saville", "Savory", "Sawin", "Sawyer", "Sawyers", "Saxon", "Saxton", "Say", "Sayer", "Sayers", "Sayles", "Sayre", "Scaggs", "Scaife", "Scalf", "Scarberry", "Scarbrough", "Scarlett", "Scates", "Scattergood", "Schofield", "Scholes", "Scholey", "Schoolcraft", "Schooley", "Schoolfield", "Schools", "Schuster", "Scism", "Scofield", "Scoggins", "Scorer", "Scott", "Scoville", "Scow", "Scranton", "Scribner", "Scrimshaw", "Scrimsher", "Scriven", "Scrivner", "Scroggins", "Scruggs", "Scruton", "Scudder", "Scull", "Scurry", "Scutt", "Sea", "Seaborn", "Seabrook", "Seager", "Seagraves", "Seal", "Seale", "Seales", "Sealock", "Seals", "Seamans", "Seamon", "Searcy", "Searle", "Sears", "Seaton", "Seaver", "Seaward", "Seawright", "Secular", "Seddon", "Sedgwick", "See", "Seed", "Seeley", "Seely", "Seelye", "Sefton", "Segal", "Segraves", "Selby", "Selden", "Seldon", "Self", "Sell", "Sellars", "Selleck", "Sellers", "Selley", "Sells", "Selph", "Selvidge", "Seneschal", "Senior", "Sensabaugh", "Senters", "Sergeant", "Session", "Sessions", "Sessoms", "Settle", "Settles", "Severance", "Severe", "Severence", "Severns", "Sewell", "Sexsmith", "Sexson", "Sexton", "Seymore", "Seymour", "Shackelford", "Shackelton", "Shackleford", "Shadduck", "Shade", "Shah", "Shakelady", "Shakespeare", "Shamblin", "Shank", "Shanks", "Sharma", "Sharman", "Sharp", "Sharpe", "Sharpless", "Sharrow", "Shattuck", "Shaw", "Shead", "Sheard", "Shears", "Shedd", "Sheets", "Sheffield", "Sheikh", "Sheilds", "Shelby", "Sheldon", "Shell", "Shelley", "Shelly", "Shelton", "Shepard", "Shepardson", "Sheperd", "Shephard", "Shepherd", "Shepley", "Sheppard", "Sherburne", "Shergill", "Shergold", "Sheridan", "Sheriff", "Sherman", "Sherrill", "Sherrod", "Sherron", "Sherwin", "Sherwood", "Shield", "Shields", "Shifflett", "Shillings", "Shingleton", "Shinn", "Shipley", "Shipman", "Shipp", "Shipton", "Shire", "Shires", "Shirley", "Shivers", "Shoemaker", "Shore", "Shores", "Short", "Shorter", "Shortt", "Shotwell", "Shoulders", "Show", "Showers", "Showman", "Shrapnel", "Shreve", "Shrewsbury", "Shropshire", "Shue", "Shurtleff", "Shute", "Shutt", "Shuttle", "Shuttleworth", "Shutts", "Sibert", "Sibley", "Siddall", "Sidebottom", "Sides", "Sidle", "Sidney", "Sidwell", "Siggers", "Sikes", "Silas", "Silcox", "Sills", "Silversmith", "Silverthorn", "Silvester", "Silvey", "Simcox", "Simeon", "Simkins", "Simmonds", "Simmonite", "Simmons", "Simms", "Simnett", "Simon", "Simonds", "Simons", "Simpkins", "Simpson", "Sims", "Sinclair", "Sinclaire", "Singh", "Singletary", "Singleton", "Siniard", "Sinkfield", "Sisson", "Sitton", "Sizemore", "Skaggs", "Skates", "Skeels", "Skegg", "Skelton", "Skidmore", "Skiles", "Skillman", "Skinner", "Skipper", "Skipworth", "Slack", "Slade", "Slater", "Slaton", "Slatter", "Slaughter", "Slawson", "Slay", "Slayden", "Slayton", "Sledge", "Sleeper", "Slocum", "Slough", "Sly", "Slye", "Small", "Smalley", "Smallman", "Smalls", "Smallwood", "Smart", "Smartt", "Smathers", "Smead", "Smedley", "Smith", "Smithee", "Smitherman", "Smithers", "Smithey", "Smithson", "Smithwick", "Smoak", "Smotherman", "Smothers", "Smyth", "Smythe", "Snape", "Snead", "Sneed", "Snell", "Snellgrove", "Snelling", "Snelson", "Snipes", "Snook", "Snow", "Snowden", "Soane", "Sockwell", "Solesbee", "Solley", "Solomon", "Somers", "Sommer", "Sommers", "Sones", "Soper", "Sorrell", "Sorrells", "Sosebee", "Soule", "Soulsby", "South", "Southall", "Southard", "Souther", "Southerland", "Southern", "Southwell", "Southwick", "Southwood", "Southworth", "Sowell", "Sowers", "Spade", "Spafford", "Spalding", "Sparkman", "Sparks", "Sparrow", "Spates", "Spaulding", "Speakman", "Speaks", "Spearman", "Spears", "Speed", "Speight", "Speights", "Speller", "Spence", "Spencer", "Spendlove", "Spenser", "Sperry", "Spicer", "Spight", "Spikes", "Spiller", "Spillers", "Spillman", "Spink", "Spinks", "Spinney", "Spires", "Spivey", "Splan", "Spooner", "Sprague", "Spratt", "Spray", "Spriggs", "Springfield", "Sproul", "Spruell", "Spruill", "Spurgeon", "Spurlin", "Spurling", "Spurlock", "Spurr", "Squall", "Squibb", "Squire", "Squires", "St. Clair", "St. John", "St. Paul", "Stacey", "Stack", "Stackhouse", "Stacks", "Stacy", "Staff", "Stafford", "Stage", "Stagg", "Staggers", "Staggs", "Stains", "Stair", "Staley", "Stallings", "Stallworth", "Stamps", "Stanaland", "Stancil", "Standard", "Standley", "Stanfield", "Stanfill", "Stanford", "Stanhope", "Stanier", "Stanley", "Stanman", "Stannard", "Stansberry", "Stansbury", "Stansfield", "Stanton", "Stanwood", "Stapler", "Stapleton", "Stapley", "Stapp", "Starbuck", "Stark", "Starkey", "Starks", "Starkweather", "Starling", "Starnes", "Starr", "Starry", "Start", "States", "Statham", "Staton", "Statum", "Stayner", "Stayton", "Stead", "Steadham", "Steadman", "Stebbins", "Steed", "Steel", "Steele", "Steere", "Steffen", "Stegall", "Stell", "Stembridge", "Stennett", "Stenson", "Stephen", "Stephens", "Stephenson", "Stepney", "Stepp", "Steptoe", "Stetson", "Stevens", "Stevenson", "Steverson", "Steveson", "Stewart", "Stickland", "Stickles", "Stickney", "Stidham", "Stiff", "Stigall", "Stiles", "Still", "Stillman", "Stillwell", "Stilson", "Stimpson", "Stimson", "Stinchcomb", "Stinnett", "Stinson", "Stinton", "Stipe", "Stirling", "Stith", "Stitt", "Stiver", "Stock", "Stockbridge", "Stockdale", "Stocking", "Stocks", "Stockstill", "Stockwell", "Stogsdill", "Stoker", "Stokes", "Stoley", "Stone", "Stoneham", "Stonehouse", "Stoneman", "Stoner", "Stoney", "Stops", "Storey", "Storr", "Storrs", "Story", "Stott", "Stoughton", "Stout", "Stovall", "Stowe", "Straight", "Strait", "Straley", "Strange", "Stranton", "Stratford", "Stratton", "Straw", "Strawbridge", "Streater", "Street", "Streeter", "Streets", "Stribling", "Strickland", "Stride", "Stringer", "Stringham", "Stripling", "Strong", "Strongfellow", "Strother", "Stroud", "Stuart", "Stubbins", "Stubblefield", "Stubbs", "Stuckey", "Studdard", "Studham", "Studley", "Sturdevant", "Sturdivant", "Sturgeon", "Sturgill", "Sturgis", "Sturman", "Sturtevant", "Styles", "Styron", "Sucksmith", "Sudbury", "Sudden", "Sudduth", "Sugg", "Suggs", "Sullins", "Sullivan", "Summerfield", "Summerford", "Summerlin", "Summers", "Summerton", "Sumner", "Sumpter", "Sunderland", "Supple", "Surratt", "Sutch", "Sutcliffe", "Suter", "Sutherland", "Sutliff", "Sutter", "Sutterfield", "Suttle", "Suttles", "Sutton", "Swafford", "Swain", "Swallow", "Swan", "Swansea", "Swanton", "Swasey", "Swayne", "Swayze", "Sweat", "Sweatman", "Sweeney", "Sweet", "Sweetapple", "Sweeting", "Sweetland", "Sweetlove", "Sweetman", "Sweetser", "Swett", "Swift", "Swindle", "Swinford", "Swofford", "Sydnor", "Sykes", "Sylvester", "Symonds", "Tabb", "Taber", "Tabor", "Tacey", "Tack", "Tackett", "Tacy", "Taft", "Tait", "Talbert", "Talbot", "Talbott", "Talkington", "Tall", "Talmadge", "Talmage", "Talton", "Tamplin", "Tankersley", "Tanksley", "Tanner", "Tant", "Tapley", "Taplin", "Tapp", "Tapper", "Tapscott", "Tarbell", "Tarbox", "Targett", "Tarkington", "Tarleton", "Tarlton", "Tarpley", "Tarrant", "Tarry", "Tart", "Tarver", "Tarvin", "Tarwater", "Tasker", "Tate", "Tatham", "Tatman", "Tatom", "Tatum", "Taunton", "Tawney", "Taylor", "Tea", "Teal", "Teasley", "Tedder", "Teed", "Teel", "Tefft", "Temple", "Templeman", "Temples", "Templeton", "Tench", "Tennant", "Tenney", "Tennison", "Tennyson", "Tenpenny", "Terrell", "Terrill", "Terry", "Tester", "Tewksbury", "Thacker", "Thackeray", "Thames", "Tharp", "Tharpe", "Thatcher", "Thaxton", "Thayer", "Theaker", "Theall", "Thedford", "Theodore", "Thetford", "Thicke", "Thistlethwait", "Thomas", "Thomason", "Thompson", "Thomson", "Thornberry", "Thornburg", "Thorndike", "Thorne", "Thornell", "Thornhill", "Thornsberry", "Thornton", "Thorp", "Thorpe", "Thorton", "Thrailkill", "Thrall", "Thrash", "Threadgill", "Threlkeld", "Thresher", "Throckmorton", "Throop", "Thrower", "Thrush", "Thurber", "Thurlow", "Thurman", "Thurmond", "Thwaites", "Thyfault", "Tibbetts", "Tibbits", "Tibbitts", "Tibbs", "Tichenor", "Tickle", "Tidd", "Tidwell", "Tiffany", "Tilcock", "Tiller", "Tilley", "Tillinghast", "Tillman", "Tillotson", "Tilson", "Tilthorpe", "Tilton", "Timberlake", "Timmins", "Timmons", "Timpson", "Tims", "Tinch", "Tincher", "Tindall", "Tindell", "Tiner", "Tingey", "Tinker", "Tinkham", "Tinsley", "Tipler", "Tippin", "Tipple", "Tipton", "Titcomb", "Titsworth", "Titterington", "Tittle", "Titus", "Toad", "Tobey", "Tobias", "Todd", "Todhunter", "Tolbert", "Toler", "Toll", "Tolle", "Tolley", "Tolman", "Tolson", "Tomblin", "Tomey", "Tomlin", "Tomlinson", "Tompkins", "Tompson", "Toms", "Toney", "Tongue", "Tooby", "Toogood", "Toomer", "Toon", "Toone", "Tooth", "Toothaker", "Tope", "Topham", "Topping", "Topps", "Torrey", "Totten", "Tovey", "Tow", "Towe", "Towell", "Tower", "Towers", "Towery", "Towle", "Towler", "Towles", "Town", "Towne", "Towner", "Townes", "Towns", "Townsend", "Townson", "Towry", "Toye", "Tozier", "Trace", "Trafford", "Trafton", "Trantham", "Trapp", "Trask", "Travers", "Travis", "Traylor", "Treadaway", "Treadway", "Treadwell", "Treat", "Tredgett", "Treece", "Treiman", "Trelawney", "Trent", "Trew", "Tribble", "Trickett", "Trigg", "Triggs", "Trim", "Trimble", "Trimm", "Trimmer", "Triplett", "Tripp", "Trivett", "Trivette", "Trogdon", "Trosley", "Trotman", "Trott", "Trotter", "Troutman", "Trowbridge", "Trower", "Troy", "True", "Trueblood", "Truelove", "Truesdale", "Truesdell", "Truitt", "Truman", "Trumble", "Trump", "Trundy", "Truss", "Trussell", "Tryon", "Tubb", "Tubbs", "Tuck", "Tucker", "Tuff", "Tuft", "Tufts", "Tuggle", "Tugwell", "Tune", "Tunkes", "Tunnell", "Tunstall", "Tupper", "Turberville", "Turbeville", "Turbyfill", "Turley", "Turlington", "Turman", "Turnage", "Turnbull", "Turner", "Turvey", "Tustin", "Tuthill", "Tuttle", "Twigg", "Twiggs", "Twilley", "Twining", "Twinn", "Twist", "Twixtchell", "Twombly", "Twyman", "Tye", "Tyer", "Tyler", "Tyndall", "Tyner", "Tyson", "Tyus", "Uddin", "Ugly", "Underdown", "Underhill", "Underwood", "Unsworth", "Upchurch", "Upham", "Upright", "Upshaw", "Upshur", "Upson", "Upthegrove", "Upton", "Urton", "Usry", "Utley", "Vail", "Vale", "Valentine", "Vance", "Vanish", "Vann", "Vantage", "Varley", "Varnes", "Varnum", "Vassilis", "Vaughan", "Vause", "Veal", "Veale", "Veasey", "Venus", "Vernon", "Verrill", "Vesey", "Vessels", "Vestal", "Vetter", "Vibbert", "Vick", "Vickers", "Vickery", "Victor", "Victory", "Vince", "Vincent", "Vine", "Vines", "Vining", "Vinson", "Vinton", "Virgin", "Vorce", "Vore", "Vose", "Voshell", "Vowell", "Waddington", "Wade", "Wadley", "Wadsworth", "Wagers", "Wages", "Wagstaff", "Wagster", "Wainscott", "Wainwright", "Wait", "Waite", "Waits", "Wakefield", "Wakeham", "Wakeland", "Wakeman", "Walborn", "Walburn", "Walcott", "Wald", "Walden", "Waldo", "Waldon", "Waldron", "Walker", "Wall", "Wallace", "Wallcroft", "Waller", "Walling", "Wallingford", "Wallis", "Walls", "Walmsley", "Walpole", "Walsh", "Walston", "Walter", "Walters", "Walthall", "Walton", "Wamsley", "Want", "Warburg", "Warburton", "Ward", "Warden", "Wardle", "Wardwell", "Ware", "Wareham", "Warehouse", "Warf", "Warfield", "Warford", "Waring", "Warman", "Warne", "Warner", "Warren", "Warrick", "Warriner", "Warwick", "Wash", "Washam", "Washburn", "Washer", "Washington", "Waslin", "Wass", "Wasson", "Waterbury", "Waterfield", "Waterhouse", "Waters", "Wathen", "Watkin", "Watkins", "Watkinson", "Watrous", "Watson", "Watt", "Watters", "Watts", "Wavell", "Waverley", "Waw", "Way", "Waye", "Wayland", "Waylen", "Wayne", "Wayt", "Weakley", "Weatherall", "Weatherfield", "Weatherill", "Weatherly", "Weatherman", "Weathers", "Weathersby", "Weatherspoon", "Weathington", "Weaver", "Webb", "Webber", "Webster", "Weddington", "Weddle", "Wedge", "Wedgworth", "Wedlock", "Weekes", "Weeks", "Weir", "Welborn", "Welch", "Welcher", "Welcome", "Weldy", "Wellborn", "Wellerman", "Welles", "Wellesley", "Wellfare", "Wellington", "Welliver", "Wells", "Welsh", "Welton", "Wentworth", "Wesley", "Wessons", "West", "Westberry", "Westbrook", "Westbrooks", "Westbury", "Westcott", "Westfield", "Westgate", "Westlake", "Westley", "Westmore", "Weston", "Westover", "Westwood", "Wetherbee", "Wetherell", "Weymouth", "Whaley", "Wharton", "Whatley", "Wheat", "Wheatland", "Wheatley", "Wheaton", "Wheeler", "Wheelhouse", "Wheeling", "Wheelis", "Wheelock", "Wheelus", "Wheelwright", "Whelan", "Whelk", "Wherritt", "Whicker", "Whidby", "Whidden", "Whiddon", "Whigham", "Whinery", "Whipple", "Whipps", "Whisker", "Whitacre", "Whitaker", "Whitby", "Whitchurch", "Whitcomb", "White", "Whiteaker", "Whited", "Whitefield", "Whitehead", "Whitehorn", "Whitehouse", "Whitehurst", "Whitelegg", "Whiteley", "Whitely", "Whiteman", "Whiteside", "Whitesides", "Whitfield", "Whitham", "Whiting", "Whitis", "Whitlatch", "Whitley", "Whitlock", "Whitlow", "Whitman", "Whitmer", "Whitmire", "Whitmore", "Whitney", "Whitson", "Whitt", "Whittaker", "Whitted", "Whittemore", "Whitten", "Whittier", "Whittingham", "Whittingstall", "Whittington", "Whittle", "Whitton", "Whitwood", "Whorton", "Whyte", "Wick", "Wicker", "Wickersham", "Wickham", "Wickle", "Wicks", "Widger", "Wig", "Wigg", "Wiggin", "Wiggins", "Wigginton", "Wiggs", "Wightman", "Wigington", "Wigley", "Wilber", "Wilbourne", "Wilburn", "Wilcher", "Wilcox", "Wilcoxon", "Wilcoxson", "Wild", "Wilde", "Wilder", "Wildes", "Wildgoose", "Wilding", "Wildman", "Wile", "Wiles", "Wilex", "Wilham", "Wilke", "Wilkens", "Wilkerson", "Wilkes", "Wilkey", "Wilkin", "Wilkins", "Wilkinson", "Wilks", "Will", "Willard", "Willbanks", "Willcox", "Willerton", "Willey", "William", "Williams", "Williamson", "Willie", "Williford", "Willingham", "Willis", "Willits", "Willoughby", "Wills", "Willson", "Wilmarth", "Wilmer", "Wilmore", "Wilmot", "Wilmoth", "Wilsey", "Wilson", "Wilton", "Wiltshire", "Wimberly", "Wimbish", "Winborne", "Winch", "Winchell", "Winchester", "Winder", "Winders", "Windham", "Windley", "Windsor", "Windus", "Winfield", "Wingate", "Winget", "Wingfield", "Wingo", "Winkfield", "Winkle", "Winn", "Winner", "Winnett", "Winningham", "Winsett", "Winship", "Winslow", "Winsor", "Winstanley", "Winstead", "Winston", "Winter", "Winters", "Winthrop", "Winwood", "Wirth", "Wisdom", "Wise", "Wiseman", "Wisham", "Witcher", "Witham", "Withem", "Witherell", "Withers", "Witherspoon", "Withey", "Withington", "Withrow", "Witten", "Wittenberg", "Witter", "Witterel", "Witty", "Wix", "Wixom", "Wixon", "Wixted", "Wofford", "Wolfe", "Wolford", "Wolstenholme", "Wolverton", "Womac", "Womack", "Womble", "Wong", "Wood", "Woodall", "Woodard", "Woodberry", "Woodbridge", "Woodbury", "Woodcock", "Woodell", "Wooden", "Woodford", "Woodger", "Woodham", "Woodhouse", "Woodiwiss", "Woodland", "Woodley", "Woodman", "Woodmansee", "Woodridge", "Woodring", "Woodrow", "Woodruff", "Woods", "Woodson", "Woodward", "Woodworth", "Woody", "Wooldridge", "Wooley", "Woolford", "Woolley", "Woolsey", "Woolverton", "Woosley", "Wooten", "Wooton", "Wootton", "Worcester", "Word", "Worden", "Wordsworth", "Work", "Workman", "Works", "World", "Worley", "Wormwood", "Worrall", "Worsham", "Worth", "Wortham", "Worthen", "Worthey", "Worthing", "Worthington", "Worthy", "Wragg", "Wray", "Wren", "Wrench", "Wright", "Wrigley", "Wriston", "Wyant", "Wyatt", "Wylie", "Wymer", "Wymore", "Wyndham", "Yale", "Yandell", "Yarber", "Yarborough", "Yarbrough", "Yard", "Yardley", "Yarnall", "Yarnell", "Yarrington", "Yates", "Yearby", "Yearwood", "Yeary", "Yeast", "Yeates", "Yeaton", "Yelverton", "Yelvington", "Yemm", "Yeoman", "Yeomans", "Yerby", "Yetman", "Yielding", "Yoke", "York", "Yorke", "Yost", "Youmans", "Young", "Younger", "Youngman", "Youngs", "Yow", "Zachary", "Zachery", "Zackery", "Zane"};
	
	private static final String[] youkoSurnames = new String[] {
			"Abiko", "Abo", "Aburaya", "Achikita",
			"Adachi", "Adachihara", "Agano", "Agata",
			"Agatsuma", "Agawa", "Aguni", "Ahane",
			"Aida", "Aihara", "Aikawa", "Aikuchi",
			"Aikyo", "Aimoto", "Ainara", "Aino",
			"Aisaka", "Aiuchi", "Akagawa", "Akagi",
			"Akahoshi", "Akai", "Akaike", "Akamatsu",
			"Akamine", "Akanishi", "Akano", "Akasaki",
			"Akashi", "Akashiro", "Akashita", "Akatsuki",
			"Akatsutsumi", "Akemi", "Aki", "Akiba",
			"Akibara", "Akimoto", "Akino", "Akisato",
			"Akishima", "Akishino", "Akita", "Akiya",
			"Amachi", "Amagai", "Amagawa", "Amai",
			"Amamiya", "Amano", "Amari", "Amatani",
			"Amaya", "Amemori", "Ametsuchi", "Amuro",
			"Amusan", "Anabuki", "Ando", "Anno",
			"Anzai", "Aoba", "Aoi", "Aoike",
			"Aoki", "Aomine", "Aonuma", "Aota",
			"Aoyagi", "Aoyama", "Aozaki", "Aozora",
			"Ara", "Aragaki", "Arai", "Arakaki",
			"Arakawa", "Araki", "Aranami", "Arashi",
			"Arashiro", "Arata", "Aratani", "Araya",
			"Arima", "Arioka", "Arisawa", "Arita",
			"Ariyoshi", "Asa", "Asahina", "Asai",
			"Asaka", "Asakawa", "Asano", "Asato",
			"Ashikaga", "Atari", "Atsuda", "Ayano",
			"Ayanokoji", "Ayanokouji", "Azahara", "Azuma",
			"Baba", "Bando", "Budou", "Bushida",
			"Chabashira", "Chage", "Chiaki", "Chiba",
			"Chibana", "Chigusa", "Chikafuji", "Chino",
			"Chisaka", "Chiura", "Chosokabe", "Chousokabe",
			"Date", "Deguchi", "Doi", "Dotani",
			"Eguchi", "Ejiri", "Enatsu", "Endo",
			"Enokida", "Enomoto", "Eto", "Etou",
			"Fuji", "Fujihara", "Fujihashi", "Fujii",
			"Fujikawa", "Fujimori", "Fujimura", "Fujinaka",
			"Fujino", "Fujinomiya", "Fujisaki", "Fujisato",
			"Fujisawa", "Fujiura", "Fujiwara", "Fujiyama",
			"Fujiyoshi", "Fukagai", "Fukami", "Fukase",
			"Fukuda", "Fukuhara", "Fukuizumi", "Fukumoto",
			"Fukunaga", "Fukushima", "Fukuyama", "Fukuyo",
			"Furukawa", "Furusawa", "Furuse", "Furuya",
			"Futaba", "Futamura", "Fuyuki", "Gato",
			"Goda", "Goto", "Gotoh", "Goya",
			"Gushiken", "Hachimitsu", "Hachimura", "Hada",
			"Haga", "Hagino", "Hagiwara", "Hajime",
			"Hama", "Hamada", "Hamadate", "Hamaguchi",
			"Hamakawa", "Hamamura", "Hamano", "Hamazaki",
			"Hanabusa", "Hanai", "Hanamura", "Hanazawa",
			"Handa", "Haneda", "Haneyama", "Hanyu",
			"Hanyuu", "Hara", "Harada", "Haraguchi",
			"Haramoto", "Harigae", "Haruki", "Haruna",
			"Haruno", "Haruta", "Haruyama", "Hasegawa",
			"Hashi", "Hashiguchi", "Hashikura", "Hashioka",
			"Hashira", "Hashitani", "Hashiyama", "Hata",
			"Hatake", "Hatano", "Hataya", "Hatsu",
			"Hattori", "Hayabusa", "Hayagawa", "Hayakawa",
			"Hayama", "Hayasaka", "Hayashibara", "Hayashida",
			"Hidaka", "Higa", "Higashi", "Higashida",
			"Higashiyama", "Himi", "Hino", "Hinode",
			"Hirai", "Hirakawa", "Hiramatsu", "Hirano",
			"Hirasaka", "Hirasawa", "Hirashima", "Hirata",
			"Hiratani", "Hiroi", "Hiromi", "Hirono",
			"Hirosawa", "Hirose", "Hiroshima", "Hirota",
			"Hiruma", "Hisamatsu", "Hitarashi", "Hitotose",
			"Hitotsuyanagi", "Hojo", "Hokinoue", "Homura",
			"Hori", "Horie", "Horigome", "Horikita",
			"Horino", "Hoshi", "Hoshimiya", "Hoshino",
			"Hoshizaki", "Hosoda", "Hosokawa", "Hosoo",
			"Houjou", "Ibuki", "Ichida", "Ichihara",
			"Ichihashi", "Ichikawa", "Ichino", "Ichinomiya",
			"Ichioka", "Ida", "Ieiri", "Iekami",
			"Igarashi", "Ige", "Ikari", "Ike",
			"Ikehara", "Ikemoto", "Ikeru", "Ikesugi",
			"Ikuta", "Imada", "Imaeda", "Imagawa",
			"Imai", "Imaishi", "Imamura", "Imari",
			"Imaruoka", "Imata", "Inagaki", "Inamura",
			"Inazuma", "Inoshishi", "Inouye", "Inui",
			"Inukai", "Iori", "Isago", "Isamu",
			"Isayama", "Ishida", "Ishido", "Ishiguro",
			"Ishihara", "Ishii", "Ishikura", "Ishimoto",
			"Ishiuchi", "Ishiwata", "Ishiyama", "Ishizuka",
			"Isobe", "Isogai", "Isozaki", "Iwaaki",
			"Iwae", "Iwamoto", "Iwano", "Iwaoka",
			"Iwasaki", "Iwashimizu", "Iwata", "Iwatani",
			"Iwayama", "Izuhara", "Izumi", "Izumo",
			"Jinnouchi", "Junko", "Kabe", "Kabuto",
			"Kadokawa", "Kadomatsu", "Kadoshima", "Kadota",
			"Kaetsu", "Kaga", "Kaiba", "Kaji",
			"Kajitani", "Kajiura", "Kajiwara", "Kaki",
			"Kakihara", "Kakimura", "Kakinuma", "Kakita",
			"Kaku", "Kakutani", "Kamata", "Kamei",
			"Kamenashi", "Kamino", "Kamiya", "Kamiyama",
			"Kamori", "Kamoto", "Kanbara", "Kanbayashi",
			"Kanbe", "Kanda", "Kaneda", "Kaneki",
			"Kaneko", "Kanemaru", "Kaneshiro", "Kanno",
			"Kanroji", "Karamatsu", "Karasu", "Kasai",
			"Kasei", "Kashiwa", "Kashiwabara", "Kashiwada",
			"Kashiwade", "Kashiwado", "Kashiwaeda", "Kashiwagi",
			"Kashiwahara", "Katagiri", "Katsura", "Kawa",
			"Kawabata", "Kawada", "Kawahara", "Kawai",
			"Kawakita", "Kawamoto", "Kawamura", "Kawanabe",
			"Kawanaka", "Kawanishi", "Kawano", "Kawasaki",
			"Kawashima", "Kawashita", "Kawata", "Kawauchi",
			"Kazama", "Kazami", "Kaze", "Kazehaya",
			"Kazetani", "Kazuyuki", "Kenma", "Kichida",
			"Kida", "Kidamura", "Kido", "Kihara",
			"Kikyo", "Kinjo", "Kino", "Kinoshita",
			"Kinugasa", "Kirigaya", "Kirimura", "Kirishima",
			"Kiriya", "Kishi", "Kishimoto", "Kitabayashi",
			"Kitagawa", "Kitahara", "Kitamura", "Kitani",
			"Kitano", "Kitao", "Kitaoka", "Kiya",
			"Kiyoko", "Kiyomizu", "Kiyota", "Kiyotake",
			"Kobashi", "Kodaira", "Kogane", "Kohira",
			"Koide", "Koigakubo", "Koike", "Kojima",
			"Kokawa", "Koki", "Komatsu", "Komatsuzaki",
			"Komiya", "Komuro", "Konaka", "Konda",
			"Kondo", "Kondou", "Konishi", "Konno",
			"Konparu", "Kosaka", "Kosugi", "Kotake",
			"Kotani", "Kotobuki", "Kotsuki", "Kouumoto",
			"Koyama", "Koyasu", "Kozue", "KÔzuke",
			"Kozuki", "Kuba", "Kubo", "Kubota",
			"Kuchiki", "Kudou", "Kuga", "Kugimiya",
			"Kuhara", "Kujira", "Kumagai", "Kumai",
			"Kumaki", "Kunida", "Kunimatsu", "Kunisaki",
			"Kurama", "Kurasawa", "Kurata", "Kuribayashi",
			"Kurihara", "Kurihashi", "Kurimoto", "Kurisu",
			"Kuriyama", "Kurizuka", "Kuroba", "Kuroda",
			"Kurogi", "Kurohashi", "Kuroiwa", "Kurokawa",
			"Kuroki", "Kuroko", "Kuromiya", "Kuronuma",
			"Kurosaka", "Kurosaki", "Kuroshima", "Kuroyanagi",
			"Kusayanagi", "Kushida", "Kushieda", "Kusunoki",
			"Kuwabara", "Kuwahara", "Kuwako", "Kyogoku",
			"Kyugoku", "Machi", "Machida", "Maebara",
			"Maejima", "Maekawa", "Maeshima", "Maeyamada",
			"Majima", "Makimura", "Makino", "Makita",
			"Manabe", "Manaka", "Mashimo", "Masuyama",
			"Matsu", "Matsubara", "Matsubayashi", "Matsuda",
			"Matsudaira", "Matsuhashi", "Matsui", "Matsukata",
			"Matsuki", "Matsumae", "Matsumura", "Matsunaga",
			"Matsunawa", "Matsuno", "Matsuo", "Matsushima",
			"Matsuura", "Matsuyama", "Matsuyuki", "Matsuzaki",
			"Mawatari", "Michizoe", "Midorikawa", "Mifune",
			"Mihara", "Mikami", "Mikazuki", "Miki",
			"Minamoto", "Minato", "Minatozaki", "Mine",
			"Misaki", "Mishima", "Miso", "Mita",
			"Mitsue", "Mitsugi", "Mitsugu", "Mitsui",
			"Miura", "Miwa", "Miya", "Miyabe",
			"Miyaguchi", "Miyahara", "Miyaichi", "Miyake",
			"Miyako", "Miyama", "Miyano", "Miyara",
			"Miyashita", "Miyata", "Miyauchi", "Miyazaki",
			"Miyazato", "Miyazawa", "Mizufuka", "Mizuhara",
			"Mizukawa", "Mizuno", "Mizusawa", "Mizuta",
			"Mizutama", "Mizutani", "Mochizuki", "Moegi",
			"Momoi", "Momose", "Moriai", "Morifuji",
			"Morihara", "Morihei", "Morikawa", "Morikita",
			"Morimoto", "Morinaka", "Morishita", "Morita",
			"Moriuchi", "Moriya", "Moriyama", "Moteki",
			"Motohashi", "Motome", "Motozawa", "Mukai",
			"Munekawa", "Mura", "Murahama", "Murahashi",
			"Murakami", "Murakawa", "Murakita", "Muramatsu",
			"Muranaka", "Muraoka", "Murashima", "Murata",
			"Muratagi", "Mushakoji", "Mushakouji", "Mushanokoji",
			"Mushanokouji", "Muto", "Mutsu", "Mutsumi",
			"Myoui", "Naegi", "Nagai", "Nagamatsu",
			"Nagano", "Nagao", "Nagaoka", "Nagashima",
			"Nagasu", "Nagato", "Nagatsuka", "Nagayama",
			"Naito", "Nakada", "Nakafuji", "Nakagame",
			"Nakagawa", "Nakai", "Nakamatsu", "Nakamine",
			"Nakamoto", "Nakanishi", "Nakao", "Nakata",
			"Nakauchi", "Nakaura", "Nakayama", "Nanami",
			"Nanashima", "Nanatsuki", "Nara", "Narisawa",
			"Narita", "Naru", "Natsukawa", "Natsumi",
			"Neho", "Neji", "Niikura", "Nikaido",
			"Ninomiya", "Nishi", "Nishida", "Nishino",
			"Nishio", "Nishiyama", "Nitta", "Nobira",
			"Nobunaga", "Nojima", "Nojiri", "Nomi",
			"Nomura", "Nonaka", "Noto", "Notou",
			"Numa", "Obara", "Oda", "Ōga",
			"Ogami", "Ogasawara", "Ogawa", "Ogita",
			"Ogura", "Oguri", "Ohama", "Ohara",
			"Ohashi", "Ohayashi", "Ohka", "Ohori",
			"Ohtani", "Oka", "Okada", "Okamoto",
			"Okamura", "Okano", "Okashima", "Okawa",
			"Okazaki", "Okochi", "Okota", "Oku",
			"Okubo", "Okudaira", "Okugawa", "Okukawa",
			"Okumura", "Okuno", "Okuyama", "Omori",
			"Omoto", "Omura", "Onishi", "Ōno",
			"Ono", "Onoue", "Oogami", "Ookouchi",
			"Ootani", "Ootono", "Osaka", "Osaki",
			"Osako", "Osato", "Osawa", "Oshima",
			"Ota", "Ōtaka", "Otaki", "Ōtani",
			"Otani", "Otonari", "Otsuka", "Ōtsuki",
			"Owari", "Oyakawa", "Oyama", "Oyamada",
			"Ozaki", "Ozawa", "Ozu", "Rikimaru",
			"Rin", "Rinbayashi", "Ritsushima", "Roka",
			"Royama", "RyŪjin", "Ryuko", "Ryumine",
			"Ryuuen", "RyŪzaki", "Saeki", "Sagami",
			"Saihara", "Saionji", "Saitama", "Saka",
			"Sakabayashi", "Sakaguchi", "Sakahara", "Sakai",
			"Sakaki", "Sakamoto", "Sakane", "Sakatani",
			"Saki", "Sakimoto", "Sakiyama", "Sakuma",
			"Sakura", "Sakurai", "Sakurami", "Sakurano",
			"Sakurazaka", "Samejima", "Samon", "Sanada",
			"Sanjo", "Sanjou", "Sano", "Sasano",
			"Sasayama", "Sasori", "Satomi", "Satoya",
			"Sawa", "Sawada", "Sawashiro", "Saza",
			"Seki", "Sekiguchi", "Senju", "Senri",
			"Serizawa", "Seto", "Setou", "Setsushi",
			"Shibasaki", "Shibata", "Shibayama", "Shibutani",
			"Shibuya", "Shima", "Shimada", "Shimadzu",
			"Shimamoto", "Shimamura", "Shimaoka", "Shimazaki",
			"Shimazu", "Shime", "Shimono", "Shimooka",
			"Shimotsuki", "Shimoyama", "Shimura", "Shinden",
			"Shinkai", "Shinobu", "Shinoda", "Shinohara",
			"Shinyama", "Shio", "Shiokawa", "Shirai",
			"Shiraishi", "Shirakawa", "Shiromori", "Shishido",
			"Shishigami", "Sho", "Shoji", "Shouyu",
			"Shoyu", "Sonoda", "Sueno", "Sueoka",
			"Suga", "Sugano", "Sugawara", "Sugieda",
			"Sugihara", "Sugimori", "Sugimoto", "Sugimura",
			"Sugino", "Sugita", "Sugitani", "Sugiura",
			"Sugiyama", "Sumisu", "Sumitomo", "Sunadori",
			"Suzukaze", "Suzumura", "Suzutani", "Suzuya",
			"Tada", "Tadokoro", "Tahara", "Taira",
			"Tajiri", "Takada", "Takagi", "Takagiri",
			"Takahara", "Takahata", "Takahide", "Takai",
			"Takaishi", "Takaki", "Takakuwa", "Takamaru",
			"Takamatsu", "Takami", "Takamitsu", "Takamori",
			"Takamura", "Takanashi", "Takano", "Takao",
			"Takase", "Takasu", "Takata", "Takayama",
			"Takayanagi", "Takazato", "Takeda", "Takehara",
			"Takei", "Takemiya", "Takemizu", "Takemura",
			"Takeno", "Takeshita", "Taketatsu", "Takeuchi",
			"Taki", "Takinoue", "Tamagawa", "Tamai",
			"Tamara", "Tamaru", "Tamashiro", "Tamatsuki",
			"Tamayama", "Tamon", "Tamura", "Tanabata",
			"Tani", "Tanigawa", "Taniguchi", "Tanihara",
			"Tanikawa", "Tanimoto", "Taniyama", "Tanji",
			"Tanose", "Tanuma", "Tatewaki", "Tatsuda",
			"Tatsumi", "Tatsuoka", "Tatsushima", "Tazawa",
			"Tekazewa", "Terada", "Terasaki", "Terauchi",
			"Tezuka", "Tobe", "Toda", "Togami",
			"Tojo", "Tokufuji", "Tokugawa", "Tokui",
			"Tomatsu", "Tomiie", "Tomita", "Tomiyasu",
			"Tomoeda", "Tomosaka", "Tomura", "Torigoe",
			"Toujou", "Toya", "Toyoda", "Toyoguchi",
			"Toyota", "Tsubo", "Tsuboi", "Tsuchida",
			"Tsuchii", "Tsuchiya", "Tsuda", "Tsudzumi",
			"Tsudzuri", "Tsuge", "Tsujihara", "Tsujii",
			"Tsujimura", "Tsujita", "Tsujiura", "Tsukahara",
			"Tsukamoto", "Tsukigata", "Tsukimi", "Tsukino",
			"Tsukiyama", "Tsukiyomi", "Tsukushi", "Tsunematsu",
			"Tsunoda", "Tsunoi", "Tsuruoka", "Tsuruta",
			"Tsutena", "Tsutsumi", "Tsuzuki", "Tsuzuno",
			"Uchida", "Uchiha", "Uchiyama", "Uehara",
			"Ueki", "Uematsu", "Uemura", "Ueshita",
			"Uesugi", "Ueta", "Umajiri", "Umeda",
			"Umehara", "Umezawa", "Umon", "Uno",
			"Uramoto", "Uraoka", "Urushihara", "Utada",
			"Utsunomiya", "Uzumaki", "Wada", "Wagahara",
			"Wakabayashi", "Wakaki", "Wakamatsu", "Wakata",
			"Wakatsuchi", "Wakuni", "Wakuri", "Watabe",
			"Watanuki", "Watari", "Yabe", "Yada",
			"Yagami", "Yagi", "Yagira", "Yakumo",
			"Yama", "Yamagata", "Yamaha", "Yamahashi",
			"Yamakawa", "Yamamizu", "Yamamura", "Yamanaka",
			"Yamane", "Yamasato", "Yamatani", "Yanagi",
			"Yanagimoto", "Yanagisawa", "Yanai", "Yasui",
			"Yasuki", "Yasunishi", "Yasuraoka", "Yasuyama",
			"Yasuzato", "Yazaki", "Yoichi", "Yoichien",
			"Yoichimae", "Yokohama", "Yokomizo", "Yokomura",
			"Yokotani", "Yokote", "Yokoyama", "Yomohiro",
			"Yonaga", "Yonamine", "Yone", "Yoneda",
			"Yoneichi", "Yonezawa", "Yoshihama", "Yoshihara",
			"Yoshii", "Yoshikawa", "Yoshimoto", "Yoshimura",
			"Yoshino", "Yoshinuma", "Yoshioka", "Yoshisawa",
			"Yui", "Yukimori", "Yukitomo", "Yukiyama",
			"Yukizome", "Yumi", "Yuuma", "Zabatsu"};
	
	private static String[] lilinNames = new String[] {
			"Lovienne",
			"Lasielle",
			"Lyssieth",
			"Lianna",
			"Lilysha",
			"Lynixi",
			"Liloria"};
	
	private static Map<String, List<NameTriplet>> racialNames = new HashMap<>();
	
	static {
		for(AbstractSubspecies subspecies : Subspecies.getAllSubspecies()) {
			if(subspecies.getRace()==Race.HORSE_MORPH) {
				racialNames.put(Subspecies.getIdFromSubspecies(subspecies), equine);
			}
			if(subspecies.getRace()==Race.REINDEER_MORPH) {
				racialNames.put(Subspecies.getIdFromSubspecies(subspecies), reindeer);
			}
		}
		
		// Modded names:
		
		Map<String, Map<String, File>> moddedFilesMap = Util.getExternalModFilesById("/race", null, "names");
		for(Entry<String, Map<String, File>> entry : moddedFilesMap.entrySet()) {
			for(Entry<String, File> innerEntry : entry.getValue().entrySet()) {
				try {
					String raceID = innerEntry.getKey().replaceAll("_race", "");
					raceID = raceID.replaceAll("_names", "");
					
					Map<String, List<NameTriplet>> importedNames = importNames(innerEntry.getValue(), entry.getKey(), true, raceID);
					if(importedNames!=null && !importedNames.isEmpty()) {
						for(Entry<String, List<NameTriplet>> importedNameEntry : importedNames.entrySet()) {
							racialNames.putIfAbsent(importedNameEntry.getKey(), new ArrayList<>());
							racialNames.get(importedNameEntry.getKey()).addAll(importedNameEntry.getValue());
						}
//						System.out.println("Added modded names of race: "+raceID);
					}
				} catch(Exception ex) {
					System.err.println("Loading modded names failed. File path: "+innerEntry.getValue().getAbsolutePath());
					System.err.println("Actual exception: ");
					ex.printStackTrace(System.err);
				}
			}
		}
		
		// External res names:
		
		Map<String, Map<String, File>> filesMap = Util.getExternalFilesById("res/race", null, "names");
		for(Entry<String, Map<String, File>> entry : filesMap.entrySet()) {
			for(Entry<String, File> innerEntry : entry.getValue().entrySet()) {
				try {
					String raceID = innerEntry.getKey().replaceAll("_race", "");
					raceID = raceID.replaceAll("_names", "");
					
					Map<String, List<NameTriplet>> importedNames = importNames(innerEntry.getValue(), entry.getKey(), false, raceID);
					if(importedNames!=null && !importedNames.isEmpty()) {
						for(Entry<String, List<NameTriplet>> importedNameEntry : importedNames.entrySet()) {
							racialNames.putIfAbsent(importedNameEntry.getKey(), new ArrayList<>());
							racialNames.get(importedNameEntry.getKey()).addAll(importedNameEntry.getValue());
						}
//						System.out.println("Added res names of race: "+raceID);
					}
				} catch(Exception ex) {
					System.err.println("Loading names failed. File path: "+innerEntry.getValue().getAbsolutePath());
					System.err.println("Actual exception: ");
					ex.printStackTrace(System.err);
				}
			}
		}
	}
	

	private static Map<String, List<NameTriplet>> importNames(File XMLFile, String author, boolean mod, String raceID) {
		if (XMLFile.exists()) {
			try {
				Document doc = Main.getDocBuilder().parse(XMLFile);
				
				// Cast magic:
				doc.getDocumentElement().normalize();
				
				Element coreElement = Element.getDocumentRootElement(XMLFile); // Loads the document and returns the root element - in statusEffect files it's <statusEffect>
				
				boolean additionalNames = Boolean.valueOf(coreElement.getAttribute("additional"));
				
				Map<String, List<NameTriplet>> importedNameMap = new HashMap<>();
				
				for(Element outerElement : coreElement.getAllOf("subspecies")) {
					String subspeciesId = outerElement.getAttribute("id");
					List<NameTriplet> importedNames = new ArrayList<>();
					for(Element e : outerElement.getAllOf("nameTriplet")) {
						String femName = e.getOptionalFirstOf("fem").isPresent()?e.getMandatoryFirstOf("fem").getTextContent():null;
						String andName = e.getOptionalFirstOf("and").isPresent()?e.getMandatoryFirstOf("and").getTextContent():null;
						String masName = e.getOptionalFirstOf("mas").isPresent()?e.getMandatoryFirstOf("mas").getTextContent():null;
						
						if(femName!=null || andName!=null || masName!=null) {
							if(femName==null) {
								femName = andName!=null?andName:masName;
							}
							if(andName==null) {
								andName = femName!=null?femName:masName;
							}
							if(masName==null) {
								masName = andName!=null?andName:femName;
							}
							importedNames.add(new NameTriplet(masName, andName, femName));
//							System.out.println("Added ("+subspeciesId+"): "+masName+", "+andName+", "+femName);
						}
					}
					if(subspeciesId.isEmpty() || subspeciesId.equalsIgnoreCase("ALL")) {
						for(AbstractSubspecies subspecies : Subspecies.getAllSubspecies()) {
							if(subspecies.getRace()==Race.getRaceFromId(raceID)) {
								importedNameMap.putIfAbsent(Subspecies.getIdFromSubspecies(subspecies), new ArrayList<>());
								importedNameMap.get(Subspecies.getIdFromSubspecies(subspecies)).addAll(importedNames);
							}
						}
						
					} else {
						importedNameMap.putIfAbsent(subspeciesId, new ArrayList<>());
						importedNameMap.get(subspeciesId).addAll(importedNames);
					}
				}
				if(additionalNames) {
					for(AbstractSubspecies subspecies : Subspecies.getAllSubspecies()) {
						if(subspecies.getRace()==Race.getRaceFromId(raceID)) {
							importedNameMap.get(Subspecies.getIdFromSubspecies(subspecies)).addAll(human);
						}
					}
				}
				
				return importedNameMap;
				
			} catch(Exception ex) {
				ex.printStackTrace();
				System.err.println("AbstractRacialBody was unable to be loaded from file! (" + XMLFile.getName() + ")\n" + ex);
			}
		}
		return null;
	}
	
	public static String getRandomName(GameCharacter gc) {
		switch(gc.getFemininity()) {
			case MASCULINE_STRONG:
			case MASCULINE:
				return getRandomTriplet(gc.getSubspecies()).getMasculine();
			case ANDROGYNOUS:
				return getRandomTriplet(gc.getSubspecies()).getAndrogynous();
			case FEMININE:
			case FEMININE_STRONG:
			default:
				return getRandomTriplet(gc.getSubspecies()).getFeminine();
		}
	}
	
	/** Surnames of all demons and half-demons reflect their Lilin lineage.<br/>
	 * For the case of descendents of Lyssieth, a surname would be:<br/>
	 * Lyssieth<b>martusarri</b> (Lyssieth's designated heir. Only Lilaya has this surname. This needs to be manually set.)<br/>
	 * Lyssieth<b>marturabitu</b> (Eldest daughter, if not the designated heir. As most Lilin's eldest daughters are also their designated heir, this surname is very rare.)<br/>
	 * Lyssieth<b>martuilani</b> (A direct daughter of Lyssieth.)<br/>
	 * Lyssieth<b>martu</b> (Lyssieth's grand-daughters or further.)<br/>
	 * <b>Note:</b> Imps descended from Lilin (in these examples, Lyssieth) are given the surname 'Lyssiethmartu', <i>however</i>, in LT's society, it is considered a great insult against Lyssieth to ever address an imp by this.
	 *  If they are ever transformed into a demon, they may use this surname, even if the Lilin who transformed them is not Lyssieth herself. (Again, however, that would be a grave insult against Lyssieth.)
	 * @param gc
	 * @return
	 */
	private static String getDemonSurname(GameCharacter gc) {
		String surname = "";
		GameCharacter mother = gc.getMother();
		
		if(mother!=null) {
			while(mother.getMother()!=null) {
				mother = mother.getMother();
			}
			if(mother.getSubspecies()==Subspecies.LILIN
					|| mother.getSubspecies()== Subspecies.ELDER_LILIN) {
				surname = mother.getName(false);
				List<GameCharacter> offspring = mother.getAllCharactersOfRelationType(Relationship.Parent);
				if(offspring.contains(gc)) {
					offspring.sort((c1, c2) -> c1.getAgeValue()-c2.getAgeValue());
					if(offspring.get(0).equals(gc)) {
						surname+="marturabitu";
					} else {
						surname+="martuilani";
					}
				} else {
					surname+="martu";
				}
			}
			
		} else {
			surname = lilinNames[Util.random.nextInt(lilinNames.length)]+"martu";
		}
		
		return surname;
	}
	
	public static String getSurname(GameCharacter gc) {
		GameCharacter mother = gc.getMother();
		if(mother!=null) {
			while(mother.getMother()!=null) {
				mother = mother.getMother();
			}
			return mother.getSurname();
		}
		
		if(gc.getBody()!=null
				&& (gc.getSubspecies()==Subspecies.FOX_ASCENDANT
						|| gc.getSubspecies()==Subspecies.FOX_ASCENDANT_ARCTIC
						|| gc.getSubspecies()==Subspecies.FOX_ASCENDANT_FENNEC)) {
			return youkoSurnames[Util.random.nextInt(youkoSurnames.length)];
		}
		if(gc.getBody()!=null) {
			if(gc.getRace()==Race.DEMON || gc.getRace()==Race.ELEMENTAL) {
				return getDemonSurname(gc);
			}
		}
		return surnames[Util.random.nextInt(surnames.length)];
	}
	
	public static NameTriplet getRandomTriplet(AbstractSubspecies subspecies) {
		NameTriplet name = Util.randomItemFrom(human);
		AbstractRace r = subspecies.getRace();
		
		if(r==Race.DEMON || r==Race.ELEMENTAL) {
			name = getDemonName();
			
		} else if(racialNames.containsKey(Subspecies.getIdFromSubspecies(subspecies))) {
			name = Util.randomItemFrom(racialNames.get(Subspecies.getIdFromSubspecies(subspecies)));
			
		} else if(Math.random()<0.1) { // If no racial names are found, then occasionally throw some "prostitute" names in there
			name = Util.randomItemFrom(prostitute); 
		}
		
		return name;
	}
	
	public static List<NameTriplet> getAllNameTriplets(AbstractSubspecies subspecies) {
		if(racialNames.containsKey(Subspecies.getIdFromSubspecies(subspecies))) {
			return new ArrayList<>(racialNames.get(Subspecies.getIdFromSubspecies(subspecies)));
		}
		return new ArrayList<>(human);
	}
	
	private static NameTriplet getDemonName() {
		String[] prefixFem = new String[] {"Aella", "Bella", "Cae", "Deva", "Ella", "Fae", "Hela", "Isa", "Katha", "Loe", "Nysa", "Oella", "Rae", "Sytha", "Vixxa", "Wynna"};
		String[] prefixMas = new String[] {"Ada", "Boro", "Foro", "Helio", "Kiri", "Zara"};
		
		String[] postfixFem = new String[] {"jyx", "ryth", "ney", "nix", "sys", "trix"};
		String[] postfixMas = new String[] {"jyx", "ryth", "ney", "nix", "sys", "trix"};
		
		String femName = prefixFem[Util.random.nextInt(prefixFem.length)] + postfixFem[Util.random.nextInt(postfixFem.length)];
		char startingChar = femName.charAt(0);

		String masName = prefixMas[Util.random.nextInt(prefixMas.length)] + postfixMas[Util.random.nextInt(postfixMas.length)];
		
		List<String> masculineNames = new ArrayList<>();
		for(String s : prefixMas) {
			if(s.charAt(0) == startingChar) {
				masculineNames.add(s);
			}
		}
		if(!masculineNames.isEmpty()) {
			masName = masculineNames.get(Util.random.nextInt(masculineNames.size())) + postfixMas[Util.random.nextInt(postfixMas.length)];
		}
		
		return new NameTriplet(masName, femName, femName);
	}
	
	public static NameTriplet getRandomProstituteTriplet() {
		// occasionally throw some "regular" names in there - 25% of the time
		if(Math.random()<0.25) {
			return Util.randomItemFrom(human);
		}
		else
		{
			return Util.randomItemFrom(prostitute);
		}
	}
}
