/* program to create student data. (Structure, Array, Fallback) */

/* solidity compiler version */
pragma solidity ^0.6;

contract Student_Management{

    /* Structure */
    struct Student{
        int stud_id;
        string stud_Name;
        string department;
    }

    /* Array */
    Student[] Students;

    function add_student_details(int stud_id, string memory stud_Name, string memory department) public {
        Student memory stud_data = Student(stud_id, stud_Name, department);
        Students.push(stud_data);
    }

    function getStudent(int stud_id) public view returns(string memory, string memory)
    {
        for(uint i=0; i<Students.length; i++){
            Student memory stud = Students[i];
            if(stud.stud_id == stud_id){
                return (stud.stud_Name, stud.department);
            }
        }

        return ("Not Found", "Not Found");
    }
}
