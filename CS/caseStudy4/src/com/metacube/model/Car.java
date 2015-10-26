package com.metacube.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


@lombok.Getter
@lombok.Setter
@EqualsAndHashCode(callSuper=true)
public class Car extends Vehicle {

	private int vehicle_id;
	private boolean AC;
	private boolean powerSteering;
	private boolean accessoryKit;
	
   

}
