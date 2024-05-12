@RestController
@RequestMapping("/nurses")
public class NurseController {

    private final NurseService nurseService;

    @Autowired
    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    // get all nurses
    @GetMapping
    public ResponseEntity<List<Nurse>> getAllNurses() {
        List<Nurse> nurses = nurseService.getAllNurses();
        return ResponseEntity.ok().body(nurses);
    }

    //get nurse by id
    @GetMapping("/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable Long id) {
        Nurse nurse = nurseService.getNurseById(id);
        return ResponseEntity.ok().body(nurse);
    }

    //create nuse
    @PostMapping
    public ResponseEntity<Nurse> createNurse(@RequestBody Nurse nurse) {
        Nurse createdNurse = nurseService.createNurse(nurse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNurse);
    }

    // update nurse 
    @PutMapping("/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable Long id, @RequestBody Nurse nurseDetails) {
        Nurse updatedNurse = nurseService.updateNurse(id, nurseDetails);
        return ResponseEntity.ok().body(updatedNurse);
    }

    // delete nurse by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNurse(@PathVariable Long id) {
        nurseService.deleteNurse(id);
        return ResponseEntity.ok().build();
    }
}