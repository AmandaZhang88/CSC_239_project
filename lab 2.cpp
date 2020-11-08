// This is 09.13 program lab 2 c++ class

#include<iostream>
#include<iomanip>
using namespace std;

int main() {

	double latestFillUp, previousFillUp, distance, gallons, mpg;

	// input the data we need
	cout << "Enter Odometer at PREVIOUS fill-up: ";
	cin >> previousFillUp;

	cout << "Enter Odometer at LATEST fill-up: ";
	cin >> latestFillUp;

	// calcuation
	distance = latestFillUp - previousFillUp;
	cout << "Distance travelled = " << fixed << setprecision(1) << distance << " miles " << endl;


	cout << "Enter gallons purchased at LATEST fill-up: ";
	cin >> gallons;

	// calcuation of fuel economy
	mpg = distance / gallons;
	cout << "Your fuel economy is: " << mpg << endl;



	system("pause");


}