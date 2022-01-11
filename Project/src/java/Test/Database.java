package Test;

import DTO.ImageDTO;
import DTO.RoleDTO;
import DTO.ServiceDTO;
import DTO.UserDTO;
import Repository.ImageRepository;
import Repository.RoleRepository;
import Repository.ServiceRepository;
import Repository.UserRepository;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class Database {
    public static void main(String[] args) {
        // Role and User
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName("Administrator");
        RoleRepository roleRepository = new RoleRepository();
        if (roleRepository.createRole(roleDTO)) System.out.println("Role '" + roleDTO.getName() + "' has been created");
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("isdown_adm");
        userDTO.setPassword("sysoperator");
        userDTO.setRole(roleDTO);
        UserRepository userRepository = new UserRepository();
        if (userRepository.createUser(userDTO)) System.out.println("User '" + userDTO.getUsername() + "' has been created");
        roleDTO = new RoleDTO();
        roleDTO.setName("Operator");
        if (roleRepository.createRole(roleDTO)) System.out.println("Role '" + roleDTO.getName() + "' has been created");
        
        // Service
        String queryAux = " (buffering OR glitching OR #isdown OR #iscrashing OR (\"is crashing\") OR (\"not working\")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet";
        ServiceRepository serviceRepository = new ServiceRepository();
        ImageRepository imageRepository = new ImageRepository();
        
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setFileName("instagram.png");
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setName("Instagram");
        serviceDTO.setQuery("(#instagram OR instagram)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
        
        imageDTO = new ImageDTO();
        imageDTO.setFileName("youtube.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Youtube");
        serviceDTO.setQuery("(#youtube OR youtube)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("facebook.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Facebook");
        serviceDTO.setQuery("(#facebook OR facebook)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("outlook.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Outlook");
        serviceDTO.setQuery("(#outlook OR outlook)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("gmail.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Gmail");
        serviceDTO.setQuery("(#gmail OR gmail)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("github.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("GitHub");
        serviceDTO.setQuery("(#github OR github)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("zoom.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Zoom");
        serviceDTO.setQuery("(#zoom OR zoom)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("googlemeet.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Google Meet");
        serviceDTO.setQuery("(#googlemeet OR google meet)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("snapchat.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Snapchat");
        serviceDTO.setQuery("(#snapchat OR snapchat)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("reddit.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Reddit");
        serviceDTO.setQuery("(#reddit OR reddit)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("twitch.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Twitch");
        serviceDTO.setQuery("(#twitch OR twitch)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("whatsapp.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Whatsapp");
        serviceDTO.setQuery("(#whatsapp OR whatsapp)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("telegram.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Telegram");
        serviceDTO.setQuery("(#telegram OR telegram)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("tiktok.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("TikTok");
        serviceDTO.setQuery("(#tiktok OR tiktok)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
                
        imageDTO = new ImageDTO();
        imageDTO.setFileName("spotify.png");
        serviceDTO = new ServiceDTO();
        serviceDTO.setName("Spotify");
        serviceDTO.setQuery("(#spotify OR spotify)" + queryAux);
        serviceDTO.setImage(imageDTO);
        imageRepository.addImage(imageDTO);
        serviceRepository.addService(serviceDTO);
    }
}
