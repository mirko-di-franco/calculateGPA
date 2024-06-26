public class CalculateGPA {

public static void main(String[] args) {
		
		int[] studentIdList = {1000, 1001, 1002, 1003, 1004, 1005};
		char[][] studentsGrades = {
				{'A','A','A','A'},
				{'C','A','B','B'},
				{'B','B','B'},
				{'A','C','C','B'},
				{'C','B','B','C','B'},
				{'A','A','B','C','B'}
		};
		
		int[] results = getStudentsByGPA(1.0, 3.0, studentIdList, studentsGrades);
		
		System.out.println("Students:");
		
		for(int idStudent : results ) {
			System.out.println("Id: "+idStudent);
		}
		
		
	}
	
	

	public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {

		//I crate an array of the same length as studentIdList
		double[] gpaList = new double[studentIdList.length];

		int count = 0;

		//I loop through the rows of the two-dimensional array
		for (char[] studentGrade : studentsGrades) {
			double gpa = 0.0;
			
			//I loop through the elements of each row
			for (char grade : studentGrade) {
				
				//With the switch statement, I convert letter grades into numerical evaluations.
				switch (grade) {
				case 'A':
					gpa += 4.0;
					break;
				case 'B':
					gpa += 3.0;
					break;
				case 'C':
					gpa += 2.0;
					break;
				}

			}
			//I add the average grade to the array.
			gpaList[count] = gpa / studentGrade.length;
			count++;

		}

		return gpaList;
	}
	
	
	

	public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
		//Return null if passed parameters are not valid
		if (lower < -1 || higher < -1 || lower > higher) {
			return null;
		}
		
		
		//invoke calculateGPA
		double[] gpaList = CalculateGPA.calculateGPA(studentIdList, studentsGrades);
		

		int count = 0;
		for (double gpa : gpaList) {
			if (gpa >= lower && gpa <= higher) {
				count++;
			}
		}

		int[] result = new int[count];

		int index = 0;
		for (int i = 0; i < gpaList.length; i++) {
			if (gpaList[i] >= lower && gpaList[i] <= higher) {
				result[index] = studentIdList[i];
				index++;
			}
		}
		
		return result;

	}
	
}
