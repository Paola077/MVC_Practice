# Veterinary Clinic

    erDiagram
    Guardian ||--o{ pet : "tiene"
    Guardian {
        Long id
        String name
        String phone
        String email
        String address
    }
    Pet {
        Long id
        String name
        String species
        String breed
        int age
        Long(FK) guardian_id 
    }
