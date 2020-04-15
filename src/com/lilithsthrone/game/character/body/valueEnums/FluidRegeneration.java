package com.lilithsthrone.game.character.body.valueEnums;

import com.lilithsthrone.utils.colours.Colour;
import com.lilithsthrone.utils.colours.PresetColour;

/**
 * Defined according to how much fluid is replenished every day, in ml.
 * 
 * @since 0.2.1
 * @version 0.3.2
 * @author Innoxia
 */
public enum FluidRegeneration {

	/** 0-50 ml/day. */
	ZERO_SLOW("slow", 0, 100, "slowly", PresetColour.GENERIC_SIZE_ONE),
	
	/** 50-500ml/day. */
	ONE_AVERAGE("average", 50, 500, "", PresetColour.GENERIC_SIZE_TWO),

	/** 500-2500 ml/day. Maximum value is roughly 0.69ml per minute. */
	TWO_FAST("fast", 500, 2500, "quickly", PresetColour.GENERIC_SIZE_THREE),

	/** 2500-10,000 ml/day. Maximum value is roughly 2.77ml per minute. */
	THREE_RAPID("rapid", 2500, 10_000, "rapidly", PresetColour.GENERIC_SIZE_FOUR),
	
	/** 10,000-50,000 ml/day. Maximum value is roughly 13.88ml per minute. */
	FOUR_VERY_RAPID("very rapid", 10_000, 50_000, "very rapidly", PresetColour.GENERIC_SIZE_FIVE);
	

	private int minimumValue;
	private int maximumValue;
	private String name;
	private String verb;
	private Colour colour;
	
	public static int CUM_REGEN_DEFAULT = 500;

	private FluidRegeneration(String name, int minimumValue, int maximumValue, String verb, Colour colour) {
		this.name = name;
		
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
		
		this.verb = verb;
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public String getVerb() {
		return verb;
	}
	
	public static FluidRegeneration getFluidRegenerationFromInt(int value) {
		for(FluidRegeneration regeneration : FluidRegeneration.values()) {
			if(value>=regeneration.getMinimumRegenerationValuePerDay() && value<regeneration.getMaximumRegenerationValuePerDay()) {
				return regeneration;
			}
		}
		return FOUR_VERY_RAPID;
	}

	public Colour getColour() {
		return colour;
	}

	// I gave them long method names as I know that I'll forget they're defined as ml/day otherwise...
	
	/**
	 * Will need to be divided by seconds per day (60*60*24), as the value returned is defined as ml per day.
	 * @return
	 */
	public int getMinimumRegenerationValuePerDay() {
		return minimumValue;
	}

	/**
	 * Will need to be divided by seconds per day (60*60*24), as the value returned is defined as ml per day.
	 * @return
	 */
	public int getMaximumRegenerationValuePerDay() {
		return maximumValue;
	}
	

	public int getMedianRegenerationValuePerDay() {
		return minimumValue + ((maximumValue - minimumValue) / 2);
	}
}
