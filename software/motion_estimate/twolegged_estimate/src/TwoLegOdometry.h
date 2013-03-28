#ifndef TWOLEGODOMETRY_H_
#define TWOLEGODOMETRY_H_

#include "TwoLegsEstimate_types.h"
#include "Footsteps.h"

#define SCHMIDT_LEVEL	      0.7f
#define TRANSITION_TIMEOUT    3000

namespace TwoLegs {

class TwoLegOdometry {
	private:
		Footsteps footsteps;
		int standing_foot;
		bool foottransitionintermediateflag;
		float expectedweight;
		footforces leftforces;
		footforces rightforces;
		long lcmutime;
		long deltautime;
		long transition_timespan;
		
		// Convert the LCM message containing robot pose information to that which is requried by the leg odometry calculations
		void parseRobotInput();
		
		// used to predict where the secondary foot is in the world.
		state getSecondaryFootState();
		
		// take new data and update local states to what the robot is doing - as is used by the motion_model estimate
		void updateInternalStates();
		
		// Used internally to change the active foot for motion estimation
		void setStandingFoot(int foot);
		
		void FootTransitionLogic();
		
		float getPrimaryFootZforce();
		float getSecondaryFootZforce();
		
	public:
		TwoLegOdometry();
		
		// Testing function not dependent on LCM messages
		void CalculateBodyStates_Testing(int counter);
		// not implemented yet
		void CalculateBodyStates();
		
		// Return which foot is which - these are based on the RIGHTFOOT and LEFTFOOT defines in TwoLegsEstiamte_types.h
		int secondary_foot();
		int primary_foot();
		

		bool DetectFootTransistion(long utime, float leftz, float rightz);
};


}

#endif /*TWOLEGODOMETRY_H_*/
