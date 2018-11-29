package com.perfectsolution.Clinique.Metier;

import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

public interface FileUploadMetier
{
    List<FileUpload> GetlistFileUp(final int num_patient);
}
