package com.hams.hamsvc.entity;

import jakarta.persistence.*;

import javax.lang.model.element.Name;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer departmentId;

        @Column(name = "department_name")
        private String departmentName;

        @ManyToOne
        @JoinColumn(name = "admin_id")
        private Admin admin; // One Admin can create many Departments

       @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
       private List<Specialization> specializations;

       @OneToMany(mappedBy = "department")
       private List<Doctor> doctors;

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public Admin getAdmin() {
            return admin;
        }

        public void setAdmin(Admin admin) {
            this.admin = admin;
        }

        public List<Specialization> getSpecializations() {
            return specializations;
        }

        public void setSpecializations(List<Specialization> specializations) {
            this.specializations = specializations;
        }
        public void setDoctors(List<Doctor> doctors){
            this.doctors=doctors;
        }
        public List<Doctor> getDoctors(){
            return doctors;
        }
    }


