package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 16, height = 16;
	
	//public static BufferedImage grass, grassTL, grassTR, grassBL, grassBR, grassT, grassR, grassB, grassL, pathwayH, pathwayV, pathwayTL, pathwayTR, pathwayBL, pathwayBR;
	//Objects
	public static BufferedImage dirt, grass, pathwayL, pathwayR, pathwayT, pathwayB, pathwayBL, pathwayBR, pathwayTL, pathwayTR, pathwayBLInv, pathwayBRInv, 
								pathwayTLInv, pathwayTRInv, treeBaseL, treeBaseR, treeMidL, treeMidR, treeTopL, treeTopR, darkRockL, darkRockR, lightRockL, 
								lightRockR, water1100, water1200, water1300, water1101, water1201, water1301, water1102, water1202, water1302, tree1718,
								tree1818, tree1719, tree1819, tree1720, tree1820, pc1, pc2, pc3, pc4, pc5, pc6, pc7, pc8, pc9, pc10, pc11, pc12, pc13, pc14, 
								pc15, pc16, pc17, pc18, pc19, pc20, pc21, pc22, pc23, pc24, pc25;
	//Character
	public static BufferedImage walkLeft1, walkLeft2, walkLeft3, walkLeft4, walkLeft5, walkLeft6, walkLeft7, walkLeft8, walkRight1, walkRight2, walkRight3, 
								walkRight4, walkRigt5, walkRight6, walkRight7, walkRight8, walkUp1, walkUp2, walkUp3, walkUp4, walkUp5, walkUp6, walkUp7, 
								walkUp8, walkDown1, walkDown2, walkDown3, walkDown4, walkDown5, walkDown6, walkDown7, walkDown8, punchUp, punchDown, punchLeft, 
								punchRight;
	
	//HUD
	public static BufferedImage heartItem, heartFull, heartHalf, heartEmpty;
	
	//Instructions
	public static BufferedImage instructions, instructionsH;
	
	//Pause Menu
	public static BufferedImage pauseMenu, pauseMenuLoad, pauseMenuMapcreator, pauseMenuQuit, pauseMenuResume, pauseMenuSave;
	
	//Map Creator
	public static BufferedImage saveButton, newButton, quitButton, downArrow, leftArrow, rightArrow, upArrow, x;
	
	public static void init(){
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/newSheet.jpg"));
		SpriteSheet textures = new SpriteSheet(ImageLoader.loadImage("/textures/Pokemon.png"));
		SpriteSheet character = new SpriteSheet(ImageLoader.loadImage("/textures/Character.png"));
		SpriteSheet animation = new SpriteSheet(ImageLoader.loadImage("/textures/CharacterPunch.png"));
		SpriteSheet health = new SpriteSheet(ImageLoader.loadImage("/textures/Health.png"));
		SpriteSheet buildings = new SpriteSheet(ImageLoader.loadImage("/textures/PokemonBuildingSprite.png"));
		SpriteSheet instructionsImage = new SpriteSheet(ImageLoader.loadImage("/textures/Instructions.png"));
		SpriteSheet instructionsHighlightedImage = new SpriteSheet(ImageLoader.loadImage("/textures/InstructionsHighlighted.png"));
		SpriteSheet pauseMenuImage = new SpriteSheet(ImageLoader.loadImage("/textures/pausemenu/PauseMenu.png"));
		SpriteSheet pauseMenuImageLoad = new SpriteSheet(ImageLoader.loadImage("/textures/pausemenu/PauseMenuLoad.png"));
		SpriteSheet pauseMenuImageMapcreator = new SpriteSheet(ImageLoader.loadImage("/textures/pausemenu/PauseMenuMapcreator.png"));
		SpriteSheet pauseMenuImageQuit = new SpriteSheet(ImageLoader.loadImage("/textures/pausemenu/PauseMenuQuit.png"));
		SpriteSheet pauseMenuImageResume = new SpriteSheet(ImageLoader.loadImage("/textures/pausemenu/PauseMenuResume.png"));
		SpriteSheet pauseMenuImageSave = new SpriteSheet(ImageLoader.loadImage("/textures/pausemenu/PauseMenuSave.png"));
		SpriteSheet saveButtonImage = new SpriteSheet(ImageLoader.loadImage("/textures/buttons/SaveButton.png"));
		SpriteSheet quitButtonImage = new SpriteSheet(ImageLoader.loadImage("/textures/buttons/QuitButton.png"));
		SpriteSheet newButtonImage = new SpriteSheet(ImageLoader.loadImage("/textures/buttons/NewButton.png"));
		SpriteSheet downArrowImage = new SpriteSheet(ImageLoader.loadImage("/textures/misc/downArrow.png"));
		SpriteSheet leftArrowImage = new SpriteSheet(ImageLoader.loadImage("/textures/misc/leftArrow.png"));
		SpriteSheet rightArrowImage = new SpriteSheet(ImageLoader.loadImage("/textures/misc/rightArrow.png"));
		SpriteSheet upArrowImage = new SpriteSheet(ImageLoader.loadImage("/textures/misc/upArrow.png"));
		SpriteSheet xImage = new SpriteSheet(ImageLoader.loadImage("/textures/misc/x.png"));
		
		//Add one more to the width of what you multiply, if at top, add one to height 
		//Textures
		dirt = textures.crop(1, 1, width, height);
		grass = textures.crop(6 * width + 7, 1, width, height);
		pathwayL = textures.crop(width + 2, 1, width, height);
		pathwayR = textures.crop(2 * width + 3, 1, width, height);
		pathwayT = textures.crop(3 * width + 4, 1, width, height);
		pathwayB = textures.crop(4 * width + 5, 1, width, height);
		pathwayBL = textures.crop(width + 2, height + 2, width, height);
		pathwayBR = textures.crop(2 * width + 3, height + 2, width, height);
		pathwayTL = textures.crop(3 * width + 4, height + 2, width, height);
		pathwayTR = textures.crop(4 * width + 5, height + 2, width, height);
		pathwayBLInv = textures.crop(2 * width + 3, 2 * height + 3, width, height);
		pathwayBRInv = textures.crop(width + 2, 2 * height + 3, width, height);
		pathwayTLInv = textures.crop(4 * width + 5, 2 * height + 3, width, height);
		pathwayTRInv = textures.crop(3 * width + 4, 2 * height + 3, width, height);
		treeBaseL = textures.crop(14 * width + 15, 19 * height + 20, width, height);
		treeBaseR = textures.crop(15 * width + 16,19 * height + 20, width, height);
		treeMidL = textures.crop(14 * width + 15, 18 * height + 19, width, height);
		treeMidR = textures.crop(15 * width + 16, 18 * height + 19, width, height);
		treeTopL = textures.crop(14 * width + 15, 17 * height + 18, width, height);
		treeTopR = textures.crop(15 * width + 16, 17 * height + 18, width, height);
		darkRockL = textures.crop(21 * width + 22, 18 * height + 19, width, height);
		darkRockR = textures.crop(22 * width + 23, 18 * height + 19, width, height);
		lightRockL = textures.crop(25 * width + 26, 18 * height + 19, width, height);
		lightRockR = textures.crop(26 * width + 27, 18 * height + 19, width, height);
		water1100 = textures.crop(10 * width + 11, 1, width, height);
		water1200 = textures.crop(11* width + 12, 1, width, height);
		water1300 = textures.crop(12 * width + 13, 1, width, height);
		water1101 = textures.crop(10 * width + 11, height + 2, width, height);
		water1201 = textures.crop(11 * width + 12, height + 2, width, height);
		water1301 = textures.crop(12 * width + 13, height + 2, width, height);
		water1102 = textures.crop(10 * width + 11, 2 * height + 3, width, height);
		water1202 = textures.crop(11 * width + 12, 2 * height + 3, width, height);
		water1302 = textures.crop(12 * width + 13, 2 * height + 3, width, height);
		tree1718 = textures.crop(16 * width + 17, 17 * height + 18, width, height);
		tree1818 = textures.crop(17 * width + 18, 17 * height + 18, width, height);
		tree1719 = textures.crop(16 * width + 17, 18 * height + 19, width, height);
		tree1819 = textures.crop(17 * width + 18, 18 * height + 19, width, height);
		tree1720 = textures.crop(16 * width + 17, 19 * height + 20, width, height);
		tree1820 = textures.crop(17 * width + 18, 19 * height + 20, width, height);
		
		//Buildings
		
		pc1 = buildings.crop(7 * width + 1, 5 * height + 2, width - 1, height - 1);
		pc2 = buildings.crop(8 * width + 2, 5 * height + 2, width - 1, height - 1);
		pc3 = buildings.crop(9 * width + 2, 5 * height + 2, width - 1, height - 1);
		pc4 = buildings.crop(10 * width + 2, 5 * height + 2, width - 1, height - 1);
		pc5 = buildings.crop(11 * width + 3, 5 * height + 2, width - 1, height - 1);
		pc6 = buildings.crop(7 * width + 1, 6 * height + 2, width - 1, height - 1);
		pc7 = buildings.crop(8 * width + 2, 6 * height + 2, width - 1, height - 1);
		pc8 = buildings.crop(9 * width + 2, 6 * height + 2, width - 1, height - 1);
		pc9 = buildings.crop(10 * width + 2,6 * height + 2, width - 1, height - 1);
		pc10 = buildings.crop(11 * width + 3, 6 * height + 2, width - 1, height - 1);
		pc11 = buildings.crop(7 * width + 1, 7 * height + 2, width - 1, height - 1);
		pc12 = buildings.crop(8 * width + 2, 7 * height + 2, width - 1, height - 1);
		pc13 = buildings.crop(9 * width + 2, 7 * height + 2, width - 1, height - 1);
		pc14 = buildings.crop(10 * width + 2, 7 * height + 2, width - 1, height - 1);
		pc15 = buildings.crop(11 * width + 3, 7 * height + 2, width - 1, height - 1);
		pc16 = buildings.crop(7 * width + 1, 8 * height + 2, width - 1, height - 1);
		pc17 = buildings.crop(8 * width + 2, 8 * height + 2, width - 1, height - 1);
		pc18 = buildings.crop(9 * width + 2, 8 * height + 2, width - 1, height - 1);
		pc19 = buildings.crop(10 * width + 2, 8 * height + 2, width - 1, height - 1);
		pc20 = buildings.crop(11 * width + 3, 8 * height + 2, width - 1, height - 1);
		pc21 = buildings.crop(7 * width + 1, 9 * height + 2, width - 1, height - 1);
		pc22 = buildings.crop(8 * width + 2, 9 * height + 2, width - 1, height - 1);
		pc23 = buildings.crop(9 * width + 2, 9 * height + 2, width - 1, height - 1);
		pc24 = buildings.crop(10 * width + 2, 9 * height + 2, width - 1, height - 1);
		pc25 = buildings.crop(11 * width + 3, 9 * height + 2, width - 1, height - 1);
		
		//Character
		// 32 x 32 
		walkLeft1 = character.crop(0, 2 * height, 2 * width,2 * height);
		walkLeft2 = character.crop(2 * width, 2 * height, 2 * width, 2 * height);
		walkLeft3 = character.crop(4 * width, 2 * height, 2 * width, 2 * height);
		walkRight1 = character.crop(0, 4 * height, 2 * width, 2 * height);
		walkRight2 = character.crop(2 * width, 4 * height, 2 * width, 2 * height);
		walkRight3 = character.crop(4 * width, 4 * height, 2 * width, 2 * height);
		walkUp1 = character.crop(0, 6 * height, 2 * width, 2 * height);
		walkUp2 = character.crop(2 * width, 6 * height, 2 * width, 2 * height);
		walkUp3 = character.crop(4 * width, 6 * height, 2 * width, 2 * height);
		walkDown1 = character.crop(0, 0, 2 * width, 2 * height);
		walkDown2 = character.crop(2 * width, 0, 2 * width, 2 * height);
		walkDown3 = character.crop(4 * width, 0, 2 * width, 2 * height);
		
		//Animation
		punchUp = animation.crop(0, 0, 2 * width, 2 * height);
		punchDown = animation.crop(2 * width, 0, 2 * width, 2 * height);
		punchLeft = animation.crop(4 * width, 0, 2 * width, 2 * height);
		punchRight = animation.crop(6 * width, 0, 2 * width, 2 * height);
		
		//HUD
		heartItem = health.crop(0, 0, 13, 12);
		heartFull = health.crop(13, 0, 13, 12);
		heartHalf = health.crop(26, 0, 13, 12);
		heartEmpty = health.crop(39, 0, 13, 12);
		
		//Instructions
		instructions = instructionsImage.crop(0, 0, 1366, 768);
		instructionsH = instructionsHighlightedImage.crop(0, 0, 1366, 768);
		
		//Pause Menu
		pauseMenu = pauseMenuImage.crop(0, 0, 1366, 768);
		pauseMenuLoad = pauseMenuImageLoad.crop(0, 0, 1366, 768);
		pauseMenuMapcreator = pauseMenuImageMapcreator.crop(0, 0, 1366, 768);
		pauseMenuQuit = pauseMenuImageQuit.crop(0, 0, 1366, 768);
		pauseMenuResume = pauseMenuImageResume.crop(0, 0, 1366, 768);
		pauseMenuSave = pauseMenuImageSave.crop(0, 0, 1366, 768);
		
		//Buttons
		newButton = newButtonImage.crop(0, 0, 150, 50);
		quitButton = quitButtonImage.crop(0, 0, 150, 50);
		saveButton = saveButtonImage.crop(0, 0, 150, 50);
		
		//Map creator
		downArrow = downArrowImage.crop(0, 0, 320, 640);
		leftArrow = leftArrowImage.crop(0, 0, 640, 320);
		rightArrow = rightArrowImage.crop(0, 0, 640, 320);
		upArrow = upArrowImage.crop(0, 0, 320, 640);
		x = xImage.crop(0, 0, 600, 525);
	}

}
