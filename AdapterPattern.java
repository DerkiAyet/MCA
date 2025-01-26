import java.util.ArrayList;

interface universalHotel {
    public void listAvailable();
    public void bookRoom(int idRoom);
}

class Chambre {
    private int id;
    private boolean disponible;

    public Chambre(int id, boolean disponible) {
        this.id = id;
        this.disponible = disponible;
    }

    public int getId() {
        return this.id;
    }

    public boolean isDisponible() {
        return this.disponible;
    }

    public void setDisponible(boolean dis) {
        this.disponible = dis;
    }
}

class CityHotel {
    public String Name;
    public ArrayList<Chambre> chambres;

    public CityHotel(String Name) {
        this.Name = Name;
        chambres = new ArrayList<>();
        chambres.add(new Chambre(1, true));
        chambres.add(new Chambre(2, false));
        chambres.add(new Chambre(3, true));
        chambres.add(new Chambre(4, false));
    }

    public ArrayList<Chambre> listRooms() {
        ArrayList<Chambre> chambresDis = new ArrayList<>();
        for (Chambre chambre : chambres) {
            if (chambre.isDisponible()) {
                chambresDis.add(chambre);
            }
        }
        return chambresDis;
    }

    public void reserveRoom(int idRoom) {
        for (Chambre chambre : chambres) {
            if (chambre.getId() == idRoom) {
                if (chambre.isDisponible()) {
                    chambre.setDisponible(false);
                    System.out.println("La chambre avec id: " + idRoom + " est réservée dans City Hotel.");
                } else {
                    System.out.println("La chambre avec id: " + idRoom + " est déjà réservée.");
                }
                return;
            }
        }
        System.out.println("Chambre avec id: " + idRoom + " non trouvée.");
    }
}

class HotelCityAdapter implements universalHotel {
    private CityHotel hotel;

    public HotelCityAdapter(CityHotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void listAvailable() {
        ArrayList<Chambre> chambres = hotel.listRooms();

        for (Chambre chambre : chambres) {
            System.out.println("la chambres avec id: " + chambre.getId() + " est disponible");
        }
    }

    @Override
    public void bookRoom(int idRoom) {
        this.hotel.reserveRoom(idRoom);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        universalHotel hotel = new HotelCityAdapter(new CityHotel("mariot"));
        useHotelPlateform(hotel);
    }

    public static void useHotelPlateform(universalHotel hotel) {
        hotel.listAvailable();
        hotel.bookRoom(1);
    }
}
